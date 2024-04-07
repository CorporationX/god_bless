package faang.school.godbless.functionalInterfaces.meta;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email", notification -> "Send the \"" + notification.message() + "\" notification via email.");

        Notification emailNotification = new Notification("email",
                "We are ready to make you an offer to junior Java developer position!");

        System.out.println(notificationManager.sendNotification(emailNotification));
    }
}
