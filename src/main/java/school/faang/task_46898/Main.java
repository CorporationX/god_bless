package school.faang.task_46898;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        manager.registerHandler("INFO", notification ->
                System.out.println("INFO Notification received: " + notification.getMessage()));
        manager.registerHandler("ERROR", notification ->
                System.out.println("ERROR Notification received: " + notification.getMessage()));
        manager.registerHandler("SUCCESS", notification ->
                System.out.println("SUCCESS " + notification.getMessage()));

        manager.sendNotification(new Notification("INFO", "Update complete"));
        manager.sendNotification(new Notification("ERROR", "Database connection error"));
        manager.sendNotification(new Notification("SUCCESS", "Backup complete"));
    }
}
