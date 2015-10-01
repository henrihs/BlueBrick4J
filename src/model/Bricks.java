package model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement ( name = "Bricks" )
public class Bricks {
	
	private List<Brick> bricks;
	
	public List<Brick> getBricks() {
		return bricks;
	}

	@XmlElement ( name = "Brick" )
	public void setBricks(List<Brick> bricks) {
		this.bricks = bricks;
	}
	
	@Override
	public String toString(){
		String r = "";
		for (Brick brick : bricks) {
			if (brick != null) { r += brick; }
		}
		return r;
	}
}
