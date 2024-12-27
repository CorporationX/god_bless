package meta_universe;

public class Main {
    public static void main(String[] args) {
        Notification email = new Notification(TypNotification.EMAIL, "Ты вонючка!");
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(TypNotification.EMAIL, notification -> {
            String massage = notification.getMessage();
            System.out.println("Отправка по электронной почте: " + massage);
            return massage;
        });
        notificationManager.sendNotification(email,notificationManager.notificationKeeper);
    }
}