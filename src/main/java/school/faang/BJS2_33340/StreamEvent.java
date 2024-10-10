package school.faang.BJS2_33340;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor
@Getter
public class StreamEvent {

    private static int idCounter;
    private static final Random random = new Random();

    private final int id;
    private String eventType;
    private String data;

    public static final String[] eventTypes = {"PowerON", "PowerOff", "Restart", "Logon", "Logout", "Access Granted",
                                                "Access Denied"};
    public static final int EVENT_TYPES_COUNT = eventTypes.length;

    public static final String[] eventDataTypes = {"System is Powered ON", "System is Powered PowerOff",
            "System is restarted", "User is logged on", "User is logged of", "Access is granted",
            "Access is denied"};

    public static StreamEvent generateEvent() {
        int eventNum = random.nextInt(eventTypes.length);
        return new StreamEvent(idCounter++, eventTypes[eventNum], eventDataTypes[eventNum]);
    }

    @Override
    public String toString(){
        return "StreamEvent [id = " + id + ", eventType = " + eventType + ", data = " + data + "] ";
    }
}
