package model;

public class UserModelOutput {
	 private String user_id;
	 private String name;
	 
	 public UserModelOutput() {}
	 
	 public UserModelOutput(UserModel userModel) {
		 this.user_id = userModel.getUser_id();
		 this.name = userModel.getName();
	 }
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	 
	 
}
