package bluebrick4j.api;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import bluebrick4j.conversion.BbmParser;
import bluebrick4j.model.Map;

public class MapFactory {
	
	public static Map getMapFromBBM(String filePath) throws NoSuchAlgorithmException, IOException {
		return BbmParser.loadMapFromFile(filePath);
	}
}
