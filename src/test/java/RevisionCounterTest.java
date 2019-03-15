import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class RevisionCounterTest {

    @Test
    public void getFirstUserRevisionNumber() {
        RevisionParser userOneParse = new RevisionParser();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sample.json");
        List<Revision> revisions = userOneParse.parse(inputStream);
        int numberOfRevisions = revisions.get(0).getNumberOfRevisions();
        Assert.assertEquals(1, numberOfRevisions);
    }

    @Test
    public void getSecondAnonUserRevisionNumber() {
        RevisionParser userOneParse = new RevisionParser();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sample.json");
        List<Revision> revisions = userOneParse.parse(inputStream);
        int numberOfRevisions = revisions.get(1).getNumberOfRevisions();
        Assert.assertEquals(2, numberOfRevisions);
    }
}
