package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement ( name = "Connexion" )
public class Connexion {
	private String id;
	private Connexion linkedTo;
	
	public String getId() {
		return id;
	}
	
	@XmlAttribute ( name = "id" )
	@XmlID
	public void setId(String id) {
		this.id = id;
	}
	public Connexion getLinkedTo() {
		return linkedTo;
	}
	
	@XmlElement ( name = "LinkedTo" )
	@XmlIDREF
	public void setLinkedTo(Connexion linkedTo) {
		this.linkedTo = linkedTo;
	}
	
	@Override
	public String toString(){
		return "Connexion: ".
				concat("\nId: ").
				concat(id).
				concat("\nLinkedTo: ").
				concat(linkedTo.getId()).
				concat("\n");
	}
}