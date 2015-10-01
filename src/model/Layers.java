package model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement ( name = "Layers" )
public class Layers {

	private List<Layer> layers;

	public List<Layer> getLayers() {
		return layers;
	}

	@XmlElement ( name = "Layer" )
	public void setLayers(List<Layer> layers) {
		this.layers = layers;
	}
	
	@Override
	public String toString() {
		String s = "";
		for (Layer layer : layers) {
			if (layer != null) { s += layer; }
		}
		return s;
	}
	
}
