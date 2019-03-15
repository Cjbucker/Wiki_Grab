import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class RevisionParser {
    String newTitle = "";

    List<Revision> parse(InputStream inputStream) {
        newTitle = "";
        Reader reader = new InputStreamReader(inputStream);
        JsonParser parser = new JsonParser();
        JsonElement rootElement = parser.parse(reader);
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonObject pages = rootObject.getAsJsonObject("query").getAsJsonObject("pages");
        JsonArray redirects = rootObject.getAsJsonObject("query").getAsJsonArray("redirects");
        setRedirect(redirects);
        ArrayList<Revision> allUserInfo = new ArrayList<>();
        JsonArray array = null;
        RevisionCounter counter = new RevisionCounter();

        for (Map.Entry<String, JsonElement> entry : pages.entrySet()) {
            JsonObject entryObject = entry.getValue().getAsJsonObject();
            array = entryObject.getAsJsonArray("revisions");
        }

        if (array != null) {
            for (int n = 0; n < array.size(); n++) {
                int count = counter.count(array, array.get(n).getAsJsonObject());
                Revision revision = new Revision(array.get(n).getAsJsonObject(), count);
                allUserInfo.add(revision);
            }
            return allUserInfo;
        }
        return allUserInfo;
    }

    private void setRedirect(JsonArray redirects) {
        if (redirects != null) {
            newTitle = redirects.get(0).getAsJsonObject().get("to").getAsString();
        }
    }
}
