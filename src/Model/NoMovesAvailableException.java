package Model;

public class NoMovesAvailableException extends Exception {
	@Override
	public String getMessage(){
		return "no moves available";
	}
}
