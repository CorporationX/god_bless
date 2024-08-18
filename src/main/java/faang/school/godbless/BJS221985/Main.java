package faang.school.godbless.BJS221985;

public class Main {
    public static void main(String[] args){
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email", notification -> System.out.println("Отправка по электронной почте: " + notification));

        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована.");

        notificationManager.sendNotification(emailNotification);
    }
}
