package school.faang;

public class Main {
    private static final NotificationManager NOTIFICATION_MANAGER = new NotificationManager();

    public static void main(String[] args) {
        // Задача мета вселенная
        for (NotificationType type : NotificationType.values()) {
            registerNotification((type));
        }

        sendNotification(NotificationType.SMS, "Код доступа 7765");
        sendNotification(NotificationType.EMAIL, "Скидки до 23%");
        sendNotification(NotificationType.PUSH, "Sent a reel by faangschool");
    }

    public static void registerNotification(NotificationType notificationType) {
        NOTIFICATION_MANAGER.registerHandler(notificationType,
                notification -> System.out.printf("%s: %s\n",
                        notification.getNotificationType(), notification.getMessage()));
    }

    public static void sendNotification(NotificationType notificationType, String message) {
        Notification notification = new Notification(notificationType, message);
        NOTIFICATION_MANAGER.sendNotification(notification);

        // Задача обрабатываем ошибки красиво
        RemoteService remoteService = new RemoteService();
        ExceptionHandler exceptionHandler = new ExceptionHandler();

        String result = exceptionHandler.withErrorHandling(
                () -> remoteService.call("some Param"),
                e -> {
                    System.out.printf("Ошибка при вызове сервиса: %s\n", e.getMessage());
                    return e.getMessage();
                }
        );
        System.out.println(result);
        
        // Задача Lord of the Rings
        InventoryManager manager = new InventoryManager();

        Character frodo = new Character("Frodo");
        Item ring = new Item("The one Ring", 1000);

        manager.addItem(frodo, ring, (item) ->
                System.out.printf("Предмет: %s был добавлен в инвентарь\n", item.getName()));
        manager.removeItem(frodo, (item) -> item.getName().equals("The one Ring"));

        manager.addItem(frodo, ring, (item) ->
                System.out.printf("Предмет: %s cнова был добавлен в инвентарь\n", item.getName()));
        manager.updateItem(frodo, (item) -> item.getName().equals("The one Ring"),
                (item) -> new Item(item.getName(), item.getValue() * 2));

        System.out.println(frodo.getInventory().get(0).getValue());
    }
}
