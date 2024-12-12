package derschrank.sprint02.task02.bjstwo_46670;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.function.Consumer;

public class NotificationManager implements NotificationManagerInterface  {
    private static final int TIMEOUT_TO_SEND_NOTIFICATIONS = 1000;
    private boolean sendingIsOnFlag;

    private Map<NotificationType, Consumer<Notification>> typeAndSendersMap;
    private Queue<Notification> listOfAwaitNotifications;
    private List<Notification> listOfSentNotifications;

    public NotificationManager() {
        typeAndSendersMap = new HashMap<>();
        listOfAwaitNotifications = new LinkedList<>();
        listOfSentNotifications = new ArrayList<>();
        sendingIsOnFlag = false;
    }

    private void startSendingNotificationByTimeOut() {
        System.out.println("startSendingNotificationByTimeOut");
        sendingIsOnFlag = true;
        Thread threadForSendingNotifications = new Thread(
                () -> {
                    while (sendingIsOnFlag) {
                        sendingNotifications();
                        try {
                            Thread.sleep(TIMEOUT_TO_SEND_NOTIFICATIONS);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );
        threadForSendingNotifications.start();
    }

    private void stopSendingNotification() {
        sendingIsOnFlag = false;
        sendingNotifications();
    }

    private void sendingNotifications() {
        System.out.println("--sendingNotifications--");
        while (!listOfAwaitNotifications.isEmpty()) {
            Notification notification =  listOfAwaitNotifications.poll();
            Consumer<Notification> consumer = typeAndSendersMap.get(notification.getType());

            consumer.accept(notification);
            listOfSentNotifications.add(notification);
        }
    }

    @Override
    public void sendNotification(Notification not) {
        listOfAwaitNotifications.add(not);
    }

    @Override
    public List<Notification> getListOfAwaitNotifications() {
        return new ArrayList<>(listOfAwaitNotifications);
    }

    @Override
    public List<Notification> getListOfSentNotifications() {
        return new ArrayList<>(listOfSentNotifications);
    }

    @Override
    public void start() {
        startSendingNotificationByTimeOut();
    }

    @Override
    public void stop() {
        stopSendingNotification();
    }

    @Override
    public void setTypeAndSenders(NotificationType type, Consumer<Notification> consumer) {
        typeAndSendersMap.put(type, consumer);
    }
}
