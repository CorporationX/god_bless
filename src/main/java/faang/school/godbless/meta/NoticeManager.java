package faang.school.godbless.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class NoticeManager {
    private Map<String, Function<Notification, Notification>> filterNoticeMap = new HashMap<>();

    public void registerHand(String type, Function<Notification, Notification> filterNotice) {
        filterNoticeMap.put(type, filterNotice);
    }

    public void sendFilteredNotification(Notification notification) {
        Function<Notification, Notification> filterNotice = filterNoticeMap.get(notification.getType());
        filterNotice.apply(notification);
    }
}
