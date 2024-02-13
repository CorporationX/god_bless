package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class NotificationManager {

    @FunctionalInterface
    public interface Consumer<Notification> {
        void accept(Notification param);
    }

    public void registerHandler(){
        Map<String, Consumer>notify=new HashMap<>();

    }

}
