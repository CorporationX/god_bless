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
        manager.registerHandler("WARNING", notification ->
                System.out.println("WARNING Notification received: " + notification.getMessage()));

        manager.registerFilter("WARNING", notification ->
                !notification.getMessage().toLowerCase().contains("ban"));
        manager.registerModifier("WARNING", notification -> {
            String sanitizedMessage = notification.getMessage()
                    .replaceAll("(?i)ban", "***");
            return new Notification(notification.getType(), sanitizedMessage);
        });

        manager.sendNotification(new Notification("INFO", "Update complete"));
        manager.sendNotification(new Notification("ERROR", "Database connection error"));
        manager.sendNotification(new Notification("SUCCESS", "Backup complete"));
        manager.sendNotification(new Notification("WARNING", "This is a ban message."));
        manager.sendNotification(new Notification("WARNING", "Disk space is low."));
    }
}
