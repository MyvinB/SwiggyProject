
package swiggy.myvin.exception;

@SuppressWarnings("serial")
public class MaxQntException extends Exception {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MaxQntException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String toString() {
		return "FoodAlreadyExistsException [message=" + message + "]";
	}
	
}