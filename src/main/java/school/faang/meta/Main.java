package school.faang.meta;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        Consumer<Notification> consumer = new Consumer<Notification>() {
            @Override
            public void accept(Notification notification) {
                System.out.println("Email: " + notification.getMessage());
            }
        };
        manager.registerHandler(NotificationType.EMAIL, consumer);
    }

}
