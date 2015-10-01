package xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import model.Map;

public class Parser {
	
	public static void main(String[] args) {
		try {
			
			File file = new File("C:\\Users\\henrihs\\Documents\\Traintracks\\station.bbm");
			JAXBContext jaxbContext = JAXBContext.newInstance(Map.class);
			
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Map map = (Map)jaxbUnmarshaller.unmarshal(file);
			System.out.println(map.toString());
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
