package exceptionsAcad;

public class CPFInvalidoException extends Exception{
	public CPFInvalidoException(String msg) {
		super("CPF Inválido.");
	}
}
