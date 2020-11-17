package metier.entities;

import java.io.Serializable;

public class Ttype implements Serializable{
private String type;
	
	
	public Ttype(String type) {
		super();
		this.type = type;
}


	public Ttype() {
		// TODO Auto-generated constructor stub
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
}