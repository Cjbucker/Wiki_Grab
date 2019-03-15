import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

class RevisionCounter {
    int count(JsonArray array, JsonObject userData) {
        int count = 0;
        for (int n = 0; n < array.size(); n++) {
            String username = userData.get("user").getAsString();
            if (username.equals(array.get(n).getAsJsonObject().get("user").getAsString())) {
                count++;
            }
        }
        return count;
    }
}