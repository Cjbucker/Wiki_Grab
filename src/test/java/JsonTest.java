import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;


public class JsonTest {

    @Test
    public void checkSizeIsFour() {
        RevisionParser userOneParse = new RevisionParser();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sample.json");
        List<Revision> revisions = userOneParse.parse(inputStream);
        Assert.assertEquals(4,revisions.size());
    }

    @Test
    public void getFirstUsername() {
        RevisionParser userOneParse = new RevisionParser();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sample.json");
        List<Revision> revisions = userOneParse.parse(inputStream);
        String username = revisions.get(0).getUsername();
        Assert.assertEquals("SemiHypercube", username);
    }

    @Test
    public void getFirstUserTime() {
        RevisionParser userOneParse = new RevisionParser();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sample.json");
        List<Revision> revisions = userOneParse.parse(inputStream);
        Date timestamp = revisions.get(0).getTimestamp();
        Assert.assertEquals("Tue Aug 14 16:34:45 EDT 2018", timestamp.toString());
    }

    @Test
    public void getSecondAnonUserIp() {
        RevisionParser userOneParse = new RevisionParser();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sample.json");
        List<Revision> revisions = userOneParse.parse(inputStream);
        String ip = revisions.get(1).getUsername();
        Assert.assertEquals("2605:6000:E501:E700:5C13:42F:83ED:316D", ip);
    }

    @Test
    public void getSecondAnonUserTime() {
        RevisionParser userOneParse = new RevisionParser();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sample.json");
        List<Revision> revisions = userOneParse.parse(inputStream);
        Date timestamp = revisions.get(1).getTimestamp();
        Assert.assertEquals("Tue Aug 14 16:34:33 EDT 2018", timestamp.toString());
    }
}
