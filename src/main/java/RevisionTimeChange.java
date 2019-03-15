import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class RevisionTimeChange {
    Date convertTime(String timestamp) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        Date date;
        try {
            date = formatter.parse(timestamp.replaceAll("Z$","+0000"));
        } catch (ParseException e) {
           throw new RuntimeException(e);
        }

        return date;
    }
}
