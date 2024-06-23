package faang.school.godbless.Task19_MetaUniverse;

public class Main {

    public static void main(String[] args) {

        NotificationManager manager = new NotificationManager();
        Notification emailNotification = new Notification("email", "Ваша учетная запись активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя");

        manager.registerHandler("email", (notification) ->
                System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        manager.registerHandler("sms", (notification) ->
                System.out.println("Отправка SMS: " + notification.getMessage()));
        manager.registerHandler("push", (notification) ->
                System.out.println("Отправка push-уведомления: " + notification.getMessage()));

        manager.sendNotification(emailNotification);
        manager.sendNotification(smsNotification);
        manager.sendNotification(pushNotification);

    }

}
