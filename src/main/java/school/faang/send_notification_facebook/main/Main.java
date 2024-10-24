package school.faang.send_notification_facebook.main;

import school.faang.send_notification_facebook.main_code.NotificationManager;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        manager.fetchAllNotifications();
    }
}
