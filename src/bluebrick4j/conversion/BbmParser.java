package bluebrick4j.conversion;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import bluebrick4j.model.Map;

public class BbmParser {
	
	public static void main(String[] args) {
		System.out.println(loadMapFromFile("demomap.bbm"));
	}
	
	public static Map loadMapFromFile(String path) {
		Map map = null;
		try {			
			File file = new File(path);
			JAXBContext jaxbContext = JAXBContext.newInstance(Map.class);
			
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			map = (Map)jaxbUnmarshaller.unmarshal(file);
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return map;
	}
}
