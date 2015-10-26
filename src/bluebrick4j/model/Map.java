package bluebrick4j.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement ( name = "Map" )
public class Map implements Serializable {
	
	private byte[] md5sum;

	private Layers layers;

	public Layers getLayers() {
		return layers;
	}

	@XmlElement ( name = "Layers" )
	public void setLayers(Layers layers) {
		this.layers = layers;
	}
	
	@Override
	public String toString(){
		return layers != null ? layers.toString() : "";
	}
	
	public byte[] getMd5Sum(){
		return md5sum;
	}
	
	public void setMd5Sum(byte[] checksum){
		md5sum = checksum;
	}
}
