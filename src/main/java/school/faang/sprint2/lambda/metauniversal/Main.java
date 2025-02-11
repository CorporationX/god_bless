package school.faang.sprint2.lambda.metauniversal;

public class Main {
    private static final String emailMessage = "Похоже, кто-то пытался войти в вашу учётную запись Discord из нового "
            + "местоположения. Если это вы, перейдите по ссылке, чтобы разрешить вход.";
    private static final String galaxyMessage = "Привет из Млечного Пути! Мы — разумные существа (но это не точно) с "
            + "планеты Земля, изучаем Вселенную и надеемся, что не одиноки. Если вы получаете это сообщение, "
            + "ответьте любым возможным способом. Мир и дружба!";
    private static final String  pushMessage = "Пользователь Evan поставил like вашему сообщению";

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        notificationManager.registerHandler(NotificationType.EMAIL, (notification) -> {
            System.out.println("Реализуем логику отправки письма, и прикрепляем текст письма: \n"
                    + notification.getMessage());
            System.out.println("Сообщение отправлено посредством " + notification.getNotificationType()); }
        );
        notificationManager.registerHandler(NotificationType.PUSH, (notification -> System.out.println(
                "Реализуем логику отправки push уведомления и прикрепляем текст: \n" + notification.getMessage())));
        notificationManager.registerHandler(NotificationType.SMS, (notification -> System.out.println(
                "Реализуем логеку отправки смс и прикрепляем текст: " + notification.getMessage())));


        Notification notification1 = new Notification(NotificationType.EMAIL, emailMessage);
        Notification notification2 = new Notification(NotificationType.PUSH, pushMessage);

        notificationManager.sendNotification(notification1);
        System.out.println();
        notificationManager.sendNotification(notification2);
        System.out.println();

        notificationManager.registerHandler(NotificationType.GALAXY_RADIO, (notification -> {
            System.out.println("Включаем гиперболоид");
            System.out.println("Настраиваем частоту и отправляем послание: ");
            System.out.println("<<< " + notification.getMessage() + " >>>");
            System.out.println("Ждем отчет о доставке сообщения тысячу лет...");
        }));

        Notification notification3 = new Notification(NotificationType.GALAXY_RADIO, galaxyMessage);
        notificationManager.sendNotification(notification3);

    }


}
