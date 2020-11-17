package metier.entities;

public class User {
	
	String username,fct;
	boolean status;
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFct() {
		return fct;
	}

	public void setFct(String fct) {
		this.fct = fct;
	}
	
	

}
