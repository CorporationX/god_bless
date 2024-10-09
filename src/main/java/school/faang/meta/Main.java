package school.faang.meta;

import java.util.List;

public class Main {

  private static final List<String> CENSORED_WORDS = List.of("violent", "dummy", "nude");

  public static void main(String[] args) {

    NotificationManager notificationManager = new NotificationManager();

    notificationManager.registerHandler("email",
        (notification) -> System.out.println("Sending email: " + notification.getMessage()));
    notificationManager.registerHandler("sms",
        (notification) -> System.out.println("Sending sms: " + notification.getMessage()));
    notificationManager.registerHandler("push",
        (notification) -> System.out.println("Sending push: " + notification.getMessage()));

    System.out.println(
        "Number of notification handlers: " + notificationManager.getNotifications().size());

    Notification pushlNotification = new Notification("push", "some message push");
    Notification emailNotification = new Notification("email", "some violent message nude");
    Notification smsNotification = new Notification("sms", "some message sms");

    notificationManager.sendNotification(pushlNotification);
    notificationManager.sendNotification(emailNotification);
    notificationManager.sendNotification(smsNotification);

    emailNotification = notificationManager.censorNotification(emailNotification,
        (notification) -> {
          notification.setMessage(correctMessage(notification.getMessage()));
          return notification;
        });
    notificationManager.sendNotification(emailNotification);
  }

  private static String correctMessage(String message) {
    for (String word : CENSORED_WORDS) {
      message = message.replaceAll(word, "***");
    }
    return "[Censored] " + message;
  }

}
