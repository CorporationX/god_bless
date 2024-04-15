package faang.school.godbless.sprint_2.meta_universe;

public class Main {

    public static void main(String[] args) {
        BadWordsManager badWordsManager = new BadWordsManager();
        badWordsManager.registerHandler("плохоеСлово", (replacementWord) -> "*".repeat(replacementWord.length()));
        badWordsManager.registerHandler("пароль", (replacementWord) -> "*".repeat(replacementWord.length()));

        NotificationManager notificationManager = new NotificationManager(badWordsManager);

        // Регистрация обработчиков оповещений
        notificationManager.registerHandler("email", (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        notificationManager.registerHandler("sms", (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()));
        notificationManager.registerHandler("push", (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));

        // Отправка оповещений
        Notification emailNotification = new Notification("email", "Ваша плохоеСлово учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}