import com.google.gson.JsonObject;

import java.util.Date;

public class Revision {
    private int numberOfRevisions;
    private String username;
    private Date timestamp;

    public Revision(JsonObject object, int numberOfRevisions) {
        RevisionTimeChange timeChange = new RevisionTimeChange();
        this.username = object.get("user").getAsString();
        this.timestamp = timeChange.convertTime(object.get("timestamp").getAsString());
        this.numberOfRevisions = numberOfRevisions;
    }
    @SuppressWarnings("WeakerAccess")
    public String getUsername() {
        return username;
    }
    @SuppressWarnings("WeakerAccess")
    public Date getTimestamp() {
        return timestamp;
    }
    @SuppressWarnings("WeakerAccess")
    public int getNumberOfRevisions() {
        return numberOfRevisions;
    }

}
