package school.faang.java.lambda.meta;

import java.util.ArrayList;
import java.util.List;

public class Main {
    NotificationManager notificationManager = new NotificationManager();
    TranslationManager translationManager = new TranslationManager();
    List<Notification> notifications = new ArrayList<>();

    public static void main(String[] args) {

        Main main = new Main();
        main.addEmail();
        main.addSMS();
        main.addTranslateSMS();
        main.addTranslateEmail();

        main.notifications.add(new Notification("SMS", "Test SMS 1"));
        main.notifications.add(new Notification("Email", "Test Email 1"));

        System.out.print("\\nn=== Init version 1.0 ==== ");
        main.notifications.forEach(notification -> main.notificationManager.sendNotification(notification));

        System.out.print("\n\n=== Extra version 2.0 ==== ");
        main.notifications.forEach(notification ->
                main.notificationManager.sendNotification(main.translationManager.translateMessage(notification)));
    }

    public void addSMS() {
        notificationManager.registerHandler("SMS",
                notification -> System.out.printf("\nSend a message type SMS: %s --> Text: %s",
                        notification.getType(),
                        notification.getMessage()));
    }

    public void addEmail() {
        notificationManager.registerHandler("Email",
                notification1 -> System.out.printf("\nSend a message type Email: %s --> Text: %s",
                        notification1.getType(),
                        notification1.getMessage()));
    }

    public void addTranslateSMS() {
        translationManager.registerTranslatorFunctionMap("SMS",
                notification -> new Notification(notification.getType(),
                        "== Translated SMS ==" + notification.getMessage()));
    }

    public void addTranslateEmail() {
        translationManager.registerTranslatorFunctionMap("Email",
                notification -> new Notification(notification.getType(),
                        "== Translated Email ==" + notification.getMessage()));
    }
}