package school.faang.meta;

public class Main {
    public static void main(String[] args) {
        Notification notification1 = new Notification(NotificationType.EMAIL, "massage in Email");
        Notification notification2 = new Notification(NotificationType.PUSH, "massage in Push");
        Notification notification3 = new Notification(NotificationType.SMS, "massage in SMS");


        NotificationManager manager = new NotificationManager();
        manager.registerHandler(NotificationType.EMAIL, massage ->
                System.out.println("Отправить на почту: " + massage.massage()));
        manager.registerHandler(NotificationType.PUSH, massage ->
                System.out.println("Вывести пуш уведомлением: " + massage.massage()));
        manager.registerHandler(NotificationType.SMS, massage ->
                System.out.println("ОТправить по SMS: " + massage.massage()));
        manager.registerHandler(null, massage -> System.out.println("Ввели не корректный тип оповещения"));

        manager.sendNotification(notification1);
        manager.sendNotification(notification2);
        manager.sendNotification(notification3);
    }
}
