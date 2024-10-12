package school.faang.meta;

import java.util.List;

public class Main {

  private static final List<String> FILTER_VIOLENCE = List.of("violent", "death", "kill");

  public static void main(String[] args) {

    NotificationManager notificationManager = new NotificationManager();

    notificationManager.registerHandler("email",
        (notification) -> System.out.println("Sending email: " + notification.getMessage()));
    notificationManager.registerHandler("sms",
        (notification) -> System.out.println("Sending sms: " + notification.getMessage()));
    notificationManager.registerHandler("push",
        (notification) -> System.out.println("Sending push: " + notification.getMessage()));

    Notification pushlNotification = new Notification("push", "some message push");
    Notification emailNotification = new Notification("email", "some violent message nude");
    Notification smsNotification = new Notification("sms", "some message kills sms");

    notificationManager.sendNotification(pushlNotification);
    notificationManager.sendNotification(emailNotification);
    notificationManager.sendNotification(smsNotification);

    String filterViolence = "violence";
    notificationManager.registerFilter(filterViolence, (notification -> {
      for (String word : FILTER_VIOLENCE) {
        if (notification.getMessage().contains(word)) {
          notification.setMessage("BLOCKED DUE TO CONTENT");
          notificationManager.sendNotification(notification);
        }
      }
      return notification;
    }));
    notificationManager.filterNotification(emailNotification, filterViolence);

    String filterViolenceCensored = "violenceCensored";
    notificationManager.registerFilter(filterViolenceCensored, (notification -> {
      notification.setMessage(correctMessage(notification.getMessage()));
      notificationManager.sendNotification(notification);
      return notification;
    }));
    notificationManager.filterNotification(smsNotification, filterViolenceCensored);
  }

  private static String correctMessage(String message) {
    for (String word : FILTER_VIOLENCE) {
      message = message.replaceAll(word, "***");
    }
    return "[Censored] " + message;
  }

}
