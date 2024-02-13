package src.main.java.faang.school.godbless;

public class Notification {
    private String type;
    private String message;
    Notification(String type,String message){
        this.type = type;
        this.message = message;
    }
    public String getType() {
        return type;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    NotificationManager notificationManager = new NotificationManager();

// Регистрация обработчиков оповещений
notificationManager.registerHandler("email", (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
notificationManager.registerHandler("sms", (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()));
notificationManager.registerHandler("push", (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));

    // Отправка оповещений
    Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
    Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
    Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

notificationManager.sendNotification(emailNotification);
notificationManager.sendNotification(smsNotification);
notificationManager.sendNotification(pushNotification);
}
