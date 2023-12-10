package faang.school.godbless.lambda.task2metaspace;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        manager.registerHandler("email", (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        manager.registerHandler("sms", (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()));
        manager.registerHandler("push", (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));

        manager.registerFilter((content) -> content.replaceAll("успешно", "****"));
        manager.registerFilter((content) -> content.replaceAll("умер", "жив здоров"));
        manager.registerFilter((content) -> content.replaceAll("ипаный", "слишком замудренный"));
        manager.registerFilter((content) -> content.replaceAll("шатал я его все", "меня переполняют эмоции"));

        Notification emailNotification = new Notification("email", "Ваша учетная запись заблакирована, шатал я его все");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой ипаный пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: умер");
        Notification unknownNotification = new Notification("unknown", "бесполезное сообщение");

        manager.sendNotification(emailNotification);
        manager.sendNotification(smsNotification);
        manager.sendNotification(pushNotification);
        manager.sendNotification(unknownNotification);

    }



}
