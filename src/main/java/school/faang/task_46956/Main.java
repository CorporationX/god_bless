package school.faang.task_46956;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        notificationManager.registerHandler("Email",
                (notification) -> System.out.println("Отправка по электронной почте"));

        Notification emailNotification = new Notification("Email", "Your email confirmed!");
        notificationManager.sendNotification(emailNotification);
    }
}
