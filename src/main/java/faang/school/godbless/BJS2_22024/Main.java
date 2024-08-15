package faang.school.godbless.BJS2_22024;

public class Main {
    public static final String SMS = "sms";
    public static final String EMAIL = "email";

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        Notification smsNotification = new Notification(SMS, "Password successfully was changed");
        Notification emailNotification = new Notification(EMAIL, "Account was successfully activated");
        notificationManager.registerHandler(SMS, notification ->
                System.out.println("Sending by sms: " + notification.getMessage()));
        notificationManager.registerHandler(EMAIL,
                notification -> System.out.println("Sending by email: " + notification.getMessage()));
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(emailNotification);

        String badwordMessage = "This message contains a badword.";
        String spamMessage = "Buy this amazing product now!";
        notificationManager.registerFilterHandler(content -> content.contains("badword"), inappropriateContent ->
                inappropriateContent.replaceAll("(?i)badword", "***"));
        notificationManager.registerFilterHandler(content -> content.contains("buy"), inappropriateContent ->
                inappropriateContent.replaceAll("(?i)buy", "***"));
        notificationManager.checkAndCorrectContent(badwordMessage);
        notificationManager.checkAndCorrectContent(spamMessage);
    }
}
