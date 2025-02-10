package translator;

public class DictionaryProcessingException extends RuntimeException {
    public DictionaryProcessingException(String message) {
        super(message);
    }

    public DictionaryProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}
