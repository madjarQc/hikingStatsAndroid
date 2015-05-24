package madjar.hikingstats.hikingstats.parsers;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

/**
 *
 * @author Alex
 */
public class KmlParser extends XmlParser {
    
    public static final String TRACKNAME  = "name";
    public static final String TIMESTAMP  = "when";
    public static final String COORDINATE = "gx:coord";
    
    private String       trackName;
    private List<Date>   timeStamp;
    private List<String> coordinate;

    public KmlParser(String filePath) throws ParserConfigurationException, IOException, SAXException {
        super(filePath);
        
        trackName  = new String();
        timeStamp  = new ArrayList<>();
        coordinate = new ArrayList<>();
        
        trackName  = getContent(TRACKNAME).get(0).toString();
        timeStamp  = getContent(TIMESTAMP);
        coordinate = getContent(COORDINATE);
    }

    public String getTrackName() {
        return trackName;
    }
    
    public List<Date> getTimeStamp() {
        return timeStamp;
    }

    public List<String> getCoordinate() {
        return coordinate;
    }
    
    
    
}
