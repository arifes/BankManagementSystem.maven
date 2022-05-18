package model;

public class UserInfoPojo {
	    private String firstName;
	    private String lastName;
		private String username;
		private String password;
		private int userID;

		
	  public UserInfoPojo(String firstName, String lastName, String username, String password, int userID) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.username = username;
			this.password = password;
			this.userID = userID;
		}


	public UserInfoPojo() {
	
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	@Override
	public String toString() {
		return "UserInfoPojo [firstName" + firstName +", lastName" + lastName +" username=" + username + ", password=" + password + ", userID=" + userID + "]";
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	

	
}	