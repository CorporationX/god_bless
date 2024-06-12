package faang.school.godbless.meta_universe;

public class Main {
    public static void main(String[] args) {

        Notification emailNotification = new Notification("email",
                "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms",
                "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push",
                "Новый пост от пользователя: JohnDoe");
        NotificationManager notificationManager = new NotificationManager();

//        notificationManager.registerHandler("email",);
    }
}
