package school.faang.meta_world;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("sms",
                notification -> System.out.println("Для вас сообщение: " + notification.message()));
        notificationManager.registerHandler("email",
                notification -> System.out.println("Ваша почта: "+ notification.message()));

        Notification smsNotification = new Notification("sms", "Оплатите ваш долг. Коллектор");
        Notification emailNotification = new Notification("email", "Вы выиграли триллион долларов! Ложитесь на дно");

        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(emailNotification);
    }
}