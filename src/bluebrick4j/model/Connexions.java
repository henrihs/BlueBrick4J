package bluebrick4j.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement ( name = "Connexions" )
public class Connexions {

	private List<Connexion> connexions;

	public List<Connexion> getConnexions() {
		return connexions;
	}

	@XmlElement ( name = "Connexion" )
	public void setConnexions(List<Connexion> connexions) {
		this.connexions = connexions;
	}
	
	@Override
	public String toString() {
		String s = "";
		for (Connexion connexion : connexions) {
			if (connexion != null) { s += connexion; }
		}
		
		return s;
	}
	
}
