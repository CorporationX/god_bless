package faang.school.godbless.BJS2_5109;

public class Main {
  public static void main(String[] args) {
    NotificationManager notificationManager = new NotificationManager();
    notificationManager.registerHandler("INFO", n -> System.out.println(n.getMessage()));
    notificationManager.registerHandler("WARNING", n -> System.out.println(n.getMessage()));

    Notification n1 = new Notification("WARNING", "warning");
    Notification n2 = new Notification("INFO", "info");

    notificationManager.sendNotification(n2);
    notificationManager.sendNotification(n1);
  }
}
