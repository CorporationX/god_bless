package school.faang.sprint_4.bjs2_37937_raven;

public class RavenLostException extends Exception {
    public RavenLostException() {
    }

    public RavenLostException(String message) {
        super(message);
    }

    public RavenLostException(String message, Throwable cause) {
        super(message, cause);
    }

    public RavenLostException(Throwable cause) {
        super(cause);
    }

    public RavenLostException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
