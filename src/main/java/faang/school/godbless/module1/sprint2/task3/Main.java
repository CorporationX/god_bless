package faang.school.godbless.module1.sprint2.task3;

public class Main {
    public static void main(String[] args) {

        // Регистрация обработчиков оповещений
        NotificationManager.registerHandler("email", (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMassage()));
        NotificationManager.registerHandler("sms", (notification) -> System.out.println("Отправка SMS: " + notification.getMassage()));
        NotificationManager.registerHandler("push", (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMassage()));
        NotificationManager.registerHandler("check", (notification) -> System.out.println("Недопустимый ввод символов: " + notification.getMassage()));

        // Отправка оповещений
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");
        Notification spamNotification = new Notification("check", "Поздравляю, вы выйграли приз, перейдите по ссылке: http:\\\\....");

        NotificationManager.spam(emailNotification);
        NotificationManager.spam(smsNotification);
        NotificationManager.spam(pushNotification);
        NotificationManager.spam(spamNotification);
    }
}
