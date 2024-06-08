package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    Map<String,String> msgStorage = new HashMap<>();
    public void registerHandler(String type, Consumer<Notification> msg){
        String msgToWrite =
        msgStorage.put(type,msg)
    }
}
