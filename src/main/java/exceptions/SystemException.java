package exceptions;

public class SystemException extends Exception{
	
	@Override
	public String getMessage() {
		return "Sorry, something went wrong. Please try again later.";
	}

}
