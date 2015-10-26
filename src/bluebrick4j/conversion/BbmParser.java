package bluebrick4j.conversion;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import bluebrick4j.model.Map;

public class BbmParser {
	
	/*
	 * Converts a .bbm file into a serialized java object
	 * @param args - String array of ['inputfile.bbm', 'outputfile.map']
	 * @return void - Serialized java object is written to designated output file
	 */
	public static void main(String[] args) {		
		try {
			convertFromBbmToMapObjectFile(args[0], args[1]);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void convertFromBbmToMapObjectFile(String inputPath, String outputPath) throws IOException, NoSuchAlgorithmException {
		Map map = loadMapFromFile(inputPath);
		saveToFile(outputPath, map);
	}
	
	public static Map loadMapFromFile(String path) throws NoSuchAlgorithmException, IOException {
		Map map = null;
		MessageDigest md = MessageDigest.getInstance("MD5");
		try (InputStream is = Files.newInputStream(Paths.get(path));
		     DigestInputStream dis = new DigestInputStream(is, md)) 
		{
			File file = new File(path);
			JAXBContext jaxbContext = JAXBContext.newInstance(Map.class);
			
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			map = (Map)jaxbUnmarshaller.unmarshal(file);
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		map.setMd5Sum(md.digest());
		return map;
	}
	
	public static void saveToFile(String path, Object object) throws IOException {
		try (
			OutputStream file = new FileOutputStream(path);
			OutputStream buffer = new BufferedOutputStream(file);
			ObjectOutput output = new ObjectOutputStream(buffer);
		) {
			output.writeObject(object);
		}
	}
}

