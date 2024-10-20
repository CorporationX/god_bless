package school.faang.tinder.exceptions;

public class UserAlreadyInChatException extends Exception {
    public UserAlreadyInChatException(String message) {
        super(message);
    }

    public UserAlreadyInChatException() {
        super();
    }
}
