package faang.school.godbless.sprint5.sendNotificationFacebook;

import faang.school.godbless.sprint5.sendNotificationFacebook.classes.Notification;
import faang.school.godbless.sprint5.sendNotificationFacebook.classes.NotificationManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        List<CompletableFuture<Notification>> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(
                    notificationManager.fetchNotifications(new Notification("Message " + i))
            );
        }

        CompletableFuture.allOf(list.toArray(new CompletableFuture[0]))
                .join();

        System.out.println(
                Arrays.toString(notificationManager.getNotifications().toArray())
        );
    }
}