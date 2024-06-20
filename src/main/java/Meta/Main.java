package Meta;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email", (notification) -> System.out.println("�������� �� ����������� �����: " + notification.getMessage()));
        notificationManager.registerHandler("sms", (notification) -> System.out.println("�������� SMS: " + notification.getMessage()));
        notificationManager.registerHandler("push", (notification) -> System.out.println("�������� push-�����������: " + notification.getMessage()));

        Notification emailNotification = new Notification("email", "���� ������� ������ ������� ������������");
        Notification smsNotification = new Notification("sms", "�� ������� �������� ���� ������");
        Notification pushNotification = new Notification("push", "����� ���� �� ������������: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);

        notificationManager.check(emailNotification);
        notificationManager.check(smsNotification);
    }
}
