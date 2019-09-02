
package swiggy.myvin.exception;

@SuppressWarnings("serial")
public class PaymentException extends Exception {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public PaymentException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String toString() {
		return "PaymnetException [message=" + message + "]";
	}
	
}