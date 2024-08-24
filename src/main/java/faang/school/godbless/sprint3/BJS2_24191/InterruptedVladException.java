package faang.school.godbless.sprint3.BJS2_24191;

public class InterruptedVladException extends InterruptedException {
    public InterruptedVladException() {
        super();
    }

    public InterruptedVladException(String message) {
        super(message);
    }

    public InterruptedVladException(String message, Throwable cause) {
        super(message);
        initCause(cause);
    }

    public InterruptedVladException(Throwable cause) {
        super();
        initCause(cause);
    }

    public String getVladMessage() {
        return this.getMessage();
    }
}

