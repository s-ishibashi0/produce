package bean;

public class Teacher implements java.io.Serializable{

	private int id;
	private String password;
	private String login;

	public int getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getLogin() {
		return login;
	}

	public void setID(int id) {
		this.id=id;
	}
	public void setLogin(String login) {
		this.login=login;
	}
	public void setPassword(String password) {
		this.password=password;
	}
}