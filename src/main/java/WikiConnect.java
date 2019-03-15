import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;


class WikiConnect {
    InputStream connect(String title)  {
        try {
            title = URLEncoder.encode(title, StandardCharsets.UTF_8.toString());
            URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles="
                    +title+"&redirects=1&rvprop=timestamp|user&rvlimit=25");
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent", "Revision tracker/0.1 (cjbucker@bsu.edu)");
            return connection.getInputStream();

        } catch(UnknownHostException | NoRouteToHostException r) {
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
