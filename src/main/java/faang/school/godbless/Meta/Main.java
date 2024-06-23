package faang.school.godbless.Meta;

public class Main {
    public static void main(String[] args){
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registrHandler("email", n ->
            System.out.println("Отправка по электронной почте: " + n.message()));
        notificationManager.registrHandler("sms", n ->
                System.out.println("Отправка SMS: " + n.message()));
        notificationManager.registrHandler("push", n ->
                System.out.println("Отправка push-уведомления: " + n.message()));

        Notification emailMessage = new Notification("email","Ваша учётная запись создана");
        Notification smsMessage = new Notification("sms","Ваш пароль изменён");
        Notification pushMessage = new Notification("push","Новый пост от пользователя Jon");

        notificationManager.sendNotification(emailMessage);
        notificationManager.sendNotification(smsMessage);
        notificationManager.sendNotification(pushMessage);
    }
}
