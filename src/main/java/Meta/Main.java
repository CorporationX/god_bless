package Meta;

public class Main {
    public static final String EMAIL = "email";
    public static final String SMS = "sms";
    public static final String PUSH = "push";
    public static final String BAD_REVIEW = "bad review";

    public static void main(String[] args) {

        NotificationManager notificationManager = new NotificationManager();

        // Регистрация обработчиков оповещений
        NotificationManager.registerHandler(EMAIL, (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        notificationManager.registerHandler(SMS, (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()));
        notificationManager.registerHandler(PUSH, (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));
        notificationManager.registerHandler(BAD_REVIEW, (notification) -> System.out.println("Кто-то оставил отзыв: " + notification.getMessage()));

        // Отправка оповещений
        Database database = Notification::new;
        Notification emailNotification = database.create(EMAIL, "Ваша учетная запись успешно активирована");
        Notification smsNotification = database.create(SMS, "Вы успешно изменили свой пароль");
        Notification pushNotification = database.create(PUSH, "Новый пост от пользователя: JohnDoe");
        Notification smsNotification2 = database.create(BAD_REVIEW, "Faang-school редиска");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(smsNotification2);
    }
}