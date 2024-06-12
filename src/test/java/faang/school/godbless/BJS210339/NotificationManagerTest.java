package faang.school.godbless.BJS210339;

import org.junit.jupiter.api.Test;
import java.util.Set;

class NotificationManagerTest {

    //TODO:12.06.2024 �������� ��� ��������� ����� ������� ��������������� ������� �� ���������� ������� � ������
    @Test
    void test() {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("censored-email",
                (notification) -> System.out.println("�������� �� ����������� �����: " + notification.getMessage())
                , Set.of("�����", "�����", "������")::contains
                , obsceneWord -> new StringBuilder(obsceneWord).reverse().toString());

        Notification censoredNotification = new Notification("censored-email", "�� �������������� �����. ���������� ������� � ���� ������ ���� ��� ����������");

        notificationManager.sendNotification(censoredNotification);
    }
}