package dima.evseenko.droid;

@FunctionalInterface
public interface DroidMessageHandler {
    void handleMessage(Droid from, String message);
}
