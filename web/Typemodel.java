package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Ttype;

public class Typemodel {

private String type;
	
private List<Ttype> types=new ArrayList<Ttype>();
public String getType() {
	return type;
}

public void setTypes(String type) {
	this.type = type;
}
public List<Ttype> getTypes() {
	return types;
}
public void setTypes(List<Ttype> types) {
	this.types = types;
}
}
