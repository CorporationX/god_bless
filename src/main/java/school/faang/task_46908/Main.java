package school.faang.task_46908;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        manager.registerHandler("INFO", notification ->
                System.out.println("[INFO]: " + notification.getMessage()));

        manager.sendNotification(new Notification("INFO", "Initialization complete."));
    }
}
