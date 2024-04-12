package faang.school.godbless.BJS2_5265;

public class Main {
    public static void main(String[] args) {
        NotificationManager notifications = new NotificationManager();

        notifications.registerHandler("taxi", notification -> System.out.println("ваше такси вызвано: " + notification.getMessage()));
        notifications.registerHandler("food", notification -> System.out.println("ваша еда готовится: " + notification.getMessage()));
        notifications.registerHandler("gym", notification -> System.out.println("вы преобрели обонемент в спортзал: " + notification.getMessage()));

        Notification taxiNotification = new Notification("taxi", "за вами приедет белы volkswagen");
        Notification foodNotification = new Notification("food", "доставим через 2 часа");
        Notification gymNotification = new Notification("gym", "ваш обонемент закончится через год");

        try {
            notifications.sendNotification(taxiNotification);
            notifications.sendNotification(foodNotification);
            notifications.sendNotification(gymNotification);
        } catch (IllegalArgumentException e) {
            System.out.println(e + "при добавлении уведомлений");
        }
    }
}
