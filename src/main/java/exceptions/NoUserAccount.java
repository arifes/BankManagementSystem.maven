package exceptions;

public class NoUserAccount extends Exception {
	
	@Override
	public String getMessage() {
		return "No User Account";
	}

}
