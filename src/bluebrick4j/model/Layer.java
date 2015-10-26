package bluebrick4j.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement ( name = "Layer" )
public class Layer implements Serializable {
	private String type;
	private Bricks bricks;

	public String getType() {
		return type;
	}

	@XmlAttribute
	public void setType(String type) {
		this.type = type;
	}

	public Bricks getBricks() {
		return bricks;
	}

	@XmlElement ( name = "Bricks" )
	public void setBricks(Bricks bricks) {
		this.bricks = bricks;
	}

	@Override
	public String toString() {
		return bricks != null ? bricks.toString() : "";
	}
	
	
}
