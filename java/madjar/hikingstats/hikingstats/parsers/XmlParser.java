package madjar.hikingstats.hikingstats.parsers;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 *
 * @author Alex
 */
public class XmlParser {
    
    File file;
    DocumentBuilderFactory factory;
    DocumentBuilder builder;
    Document doc;
    NodeList nodes;

    public XmlParser(String filePath) throws ParserConfigurationException, IOException, SAXException {
        
        this.file = new File(filePath);
        
        this.factory = DocumentBuilderFactory.newInstance();
        this.builder = factory.newDocumentBuilder();
        this.doc     = builder.parse(file);
        
        doc.getDocumentElement().normalize();
        
    }

    public ArrayList getContent(String pNodes) {
        
        ArrayList contentList = new ArrayList();
        
        nodes = doc.getElementsByTagName(pNodes);
        
        for (int i = 0; i < nodes.getLength(); i++) {
            
            Node node = nodes.item(i);
            
            if (node.getNodeType() == Node.ELEMENT_NODE){
                
                contentList.add(node.getTextContent());
                
            }
        }
        return contentList;
    }
}
