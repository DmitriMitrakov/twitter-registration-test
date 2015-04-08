package data;

public class TestUser {
	
	private final String name;
	private final String password;
	private final String email;
	
	public TestUser(String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email + System.currentTimeMillis();
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}
		
}
