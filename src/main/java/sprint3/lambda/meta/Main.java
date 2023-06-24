package sprint3.lambda.meta;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        init(manager);

        Notification emailNotification = new Notification("email", "���� ������� ������ ������� ������������");
        Notification smsNotification = new Notification("sms", "�� ������� �������� ���� ������");
        Notification pushNotification = new Notification("push", "����� ���� �� ������������: JohnDoe");

        manager.sendNotification(emailNotification);
        manager.sendNotification(smsNotification);
        manager.sendNotification(pushNotification);
    }

    private static void init(NotificationManager manager) {
        manager.registerHandler("email", (notification) ->
                System.out.println("�������� �� ����������� �����: " + notification.getMessage()));
        manager.registerHandler("sms", (notification) ->
                System.out.println("�������� SMS: " + notification.getMessage()));
        manager.registerHandler("push", (notification) ->
                System.out.println("�������� push-�����������: " + notification.getMessage()));

        manager.registerNotificationLengthChecks("sms", notification ->
                notification.getMessage().length() <= 150);
        manager.registerNotificationLengthChecks("push", notification ->
                notification.getMessage().length() <= 50);
    }

}
