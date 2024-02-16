package faang.school.godbless.meta;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

// Регистрация обработчиков оповещений
        notificationManager.registerHandler("email",(notification)->System.out.println("Отправка по электронной почте: "+notification.getMessage()));
        notificationManager.registerHandler("sms",(notification)->System.out.println("Отправка SMS: "+notification.getMessage()));
        notificationManager.registerHandler("push",(notification)->System.out.println("Отправка push-уведомления:"+notification.getMessage()));

        // Отправка оповещений
        Notification emailNotification = new Notification( "email", "Spam Ваша учетная запись успешно активирована" );
        Notification smsNotification = new Notification( "sms", "Вы успешно изменили свой пароль" );
        Notification pushNotification = new Notification( "push", "Новый пост от пользователя: JohnDoe virus" );

        notificationManager.registerFilter(n -> n.getMessage().toLowerCase().contains("spam"));
        notificationManager.registerFilter(n -> n.getMessage().toLowerCase().contains("virus"));

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);

    }
}
