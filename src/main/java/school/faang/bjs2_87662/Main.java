package school.faang.bjs2_87662;

import java.util.function.Consumer;

import static school.faang.bjs2_87662.NotificationType.*;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        Notification not1 = new Notification(EMAIL, "Formal email");
        Notification not2 = new Notification(SMS, "Formal sms");
        Notification not3 = new Notification(PUSH, "Formal push");

        Consumer<Notification> cons1 = not -> System.out.println(not.getMessage());
        Consumer<Notification> cons2 = not -> System.out.println(not.getMessage() + " sms");
        Consumer<Notification> cons3 = not -> System.out.println(not.getMessage() + " push");

        manager.registerHandler(EMAIL, cons1);
        manager.registerHandler(SMS, cons2);
        manager.registerHandler(PUSH, cons3);

        manager.addProofreader(s -> "Google " + s);
        manager.addProofreader(s -> s + " Google");

        manager.sendNotification(not1);
        manager.sendNotification(not2);
        manager.sendNotification(not3);
    }
}
