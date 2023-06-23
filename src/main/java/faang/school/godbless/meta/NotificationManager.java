package faang.school.godbless.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class NotificationManager {
    private Map<String, Consumer<Notification>> map = new HashMap<>();

    public void registerHandler(String message, Consumer<Notification> consumer) {
        if (!map.containsKey(message)) {
            map.put(message, consumer);
        }
    }

    public void sendNotification(Notification notification) {
        for (Map.Entry<String, Consumer<Notification>> entry : map.entrySet()) {
            if (notification.getType().equals(entry.getKey())) {
                System.out.println(entry.getValue());
            }
        }
    }

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
    }
}
