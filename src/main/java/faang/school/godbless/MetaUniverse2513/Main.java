package faang.school.godbless.MetaUniverse2513;

public class Main {
    static final String PUSH = "Push";
    static final String TELEGRAM = "Telegram";
    static final String E_MAIL = "E-Mail";

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        notificationManager.registerHandler(PUSH, (notification) -> System.out.println("Sending a push to User's phone: " + notification.getMessage()));
        notificationManager.registerHandler(TELEGRAM, (notification) -> System.out.println("Sending a message to user's TG account: " + notification.getMessage()));
        notificationManager.registerHandler(E_MAIL, (notification) -> System.out.println("Sending an E-mail to User: " + notification.getMessage()));

        Notification test1 = new Notification(PUSH, "Your package is arrived");
        Notification test2 = new Notification(TELEGRAM, "\"Mom\" sent you a message");
        Notification test3 = new Notification(TELEGRAM, "\"Love\" sent you a message");
        Notification test4 = new Notification(E_MAIL, "Don't forget to renew your subscription");

        notificationManager.sendNotification(test1);
        notificationManager.sendNotification(test2);
        notificationManager.sendNotification(test3);
        notificationManager.sendNotification(test4);

        Notification test5 = new Notification(E_MAIL, "Bad Word");
        Notification test6 = new Notification(E_MAIL, "Good Word");

        notificationManager.registerFilter(test1.getMessage(), (message) -> message.getMessage().contains("Bad Word"));
        notificationManager.registerFilter(test2.getMessage(), (message) -> message.getMessage().contains("Bad Word"));
        notificationManager.registerFilter(test3.getMessage(), (message) -> message.getMessage().contains("Bad Word"));
        notificationManager.registerFilter(test4.getMessage(), (message) -> message.getMessage().contains("Bad Word"));
        notificationManager.registerFilter(test5.getMessage(), (message) -> message.getMessage().contains("Bad Word"));
        notificationManager.registerFilter(test6.getMessage(), (message) -> message.getMessage().contains("Bad Word"));

        notificationManager.filterNotifications(test1);
        notificationManager.filterNotifications(test2);
        notificationManager.filterNotifications(test3);
        notificationManager.filterNotifications(test4);
        notificationManager.filterNotifications(test5);
        notificationManager.filterNotifications(test6);
    }
}
