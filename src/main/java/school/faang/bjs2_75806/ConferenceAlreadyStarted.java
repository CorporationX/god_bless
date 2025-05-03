package school.faang.bjs2_75806;

public class ConferenceAlreadyStarted extends RuntimeException {
    public ConferenceAlreadyStarted() {
        super("Conference already started");
    }
}
