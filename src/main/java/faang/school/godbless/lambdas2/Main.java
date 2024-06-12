package faang.school.godbless.lambdas2;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = getNotificationManager();

// �������� ����������
        Notification emailNotification = new Notification("email", "���� ������� ������ ������� ������������");
        Notification smsNotification = new Notification("sms", "�� ������� �������� ���� ������");
        Notification pushNotification = new Notification("push", "����� ���� �� ������������: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }

    private static NotificationManager getNotificationManager() {
        NotificationManager notificationManager = new NotificationManager();

// ����������� ������������ ����������
        notificationManager.registerHandler("email", (notification) -> System.out.println("�������� �� ����������� �����: " + notification.message()));
        notificationManager.registerHandler("sms", (notification) -> System.out.println("�������� SMS: " + notification.message()));
        notificationManager.registerHandler("push", (notification) -> System.out.println("�������� push-�����������: " + notification.message()));
        return notificationManager;
    }
}
