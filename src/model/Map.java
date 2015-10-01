package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement ( name = "Map" )
public class Map {

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
}
