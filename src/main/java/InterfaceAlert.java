import java.io.InputStream;
import java.util.List;

class InterfaceAlert {
    String CheckNetAvailable(InputStream inputStream){
        if (inputStream == null){
            return "Check your internet connection and try again.";
        }
        else{
           return "";
        }
    }

    String DoesWikiExist(List<Revision> revisions) {
        if (revisions.isEmpty()){
            return "Wiki Does Not Exist.";
        } else {
            return "";
        }
    }

}
