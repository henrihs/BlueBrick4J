package bluebrick4j.model;

import java.util.UnknownFormatConversionException;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement ( name = "Brick" )
public class Brick {
	
	private String id;
	private double partNumber;
	private Connexions connexions;
	
	public String getId() {
		return id;
	}

	@XmlAttribute ( name = "id" )
	@XmlID
	public void setId(String id) {
		this.id = id;
	}

	public double getPartNumber() {
		return partNumber;
	}

	@XmlElement ( name = "PartNumber" )
	public void setPartNumber(double partNumber) {
		this.partNumber = partNumber;
	}
	
	public Connexions getConnexions() {
		return connexions;
	}
	
	@XmlElement ( name = "Connexions" )
	public void setConnexions(Connexions connexions) {
		this.connexions = connexions;
	}	
	
	@Override
	public String toString(){
		String s = "Brick:".
				concat("\nId: ").
				concat(id).
				concat("\nPartNumber: ").
				concat(String.valueOf(partNumber)).
				concat("\n");
		if (connexions != null) { 
			s += connexions + "\n"; 
		}
		
		return s;
	}

	public BrickType getBrickType() {
		switch (String.valueOf(partNumber)) {
		case "2859.8":
			return BrickType.RIGHTHANDPOINTSWITCH;
		case "2861.8":
			return BrickType.LEFTHANDPOINTSWITCH;
		case "2865.8":
			return BrickType.STRAIGHT;
		case "2867.8":
			return BrickType.CURVED;
		default:
			throw new UnknownFormatConversionException("Part number not recognized (" + (partNumber) + ")");
		}
	}
}
