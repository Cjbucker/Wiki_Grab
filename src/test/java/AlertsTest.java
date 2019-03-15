import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;

public class AlertsTest {

    @Test
    public void checkIfWikiDoesntExistTest (){
        ArrayList<Revision> alertTest = new ArrayList<>();
        InterfaceAlert alert = new InterfaceAlert();
        Assert.assertEquals("Wiki Does Not Exist.", alert.DoesWikiExist(alertTest));
    }

    @Test
    public void WikiExistsTest(){
        ArrayList alertTest = new ArrayList();
        InterfaceAlert alert = new InterfaceAlert();
        alertTest.add("Hi I'm Paul!");
        Assert.assertEquals("",alert.DoesWikiExist(alertTest));
    }

    @Test
    public void InternetDoesntExistTest(){
        InterfaceAlert alert = new InterfaceAlert();
        InputStream inputStream = null;
        Assert.assertEquals("Check your internet connection and try again.",alert.CheckNetAvailable(inputStream));
    }

    @Test
    public void InternetDoesExistTest(){
        InterfaceAlert alert = new InterfaceAlert();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sample.json");
        Assert.assertEquals("",alert.CheckNetAvailable(inputStream));
    }
}
