package school.faang.task_46907;

import lombok.Data;


public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("Бумажное письмо",
                (notification) -> System.out.println("Отправка бумажным письмом: " + notification.getMessage())
        );

        notificationManager.registerHandler("Push",
                (notification) -> System.out.println("Отправка push-уведомлением: " + notification.getMessage())
        );

        Notification letterNotification = new Notification("Бумажное письмо",
                "Ваше сообщение пришло с опозданием. Повторите попытку или используйте другой способ доставки");

        Notification pushNotification = new Notification("Push", "Операция по переводу средств завершена");

        notificationManager.sendNotification(letterNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
