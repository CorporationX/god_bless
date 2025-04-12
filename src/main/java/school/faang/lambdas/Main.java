package school.faang.lambdas;

import lombok.extern.slf4j.Slf4j;
import school.faang.lambdas.corrector.AmazonCorrector;
import school.faang.lambdas.corrector.TwitterCorrector;
import school.faang.lambdas.exceptions.IllegalMessageException;
import school.faang.lambdas.moderator.DumbModerator;

@Slf4j
public class Main {

    public static void main(String[] args) {

        String messageTemplate = "%s message: %s";

        NotificationManager amazonMessageManager = new NotificationManager(new DumbModerator(), new AmazonCorrector())
                .registerHandler(NotificationType.EMAIL, notification ->
                        System.out.printf((messageTemplate) + "%n", notification.type(), notification.message()))
                .registerHandler(NotificationType.SMS, notification ->
                        System.out.printf((messageTemplate) + "%n", notification.type(), notification.message()))
                .registerHandler(NotificationType.PUSH, notification ->
                        System.out.printf((messageTemplate) + "%n", notification.type(), notification.message()));

        amazonMessageManager.sendNotification(new Notification(NotificationType.EMAIL, "send email to you"));
        amazonMessageManager.sendNotification(new Notification(NotificationType.SMS, "send sms to you"));
        amazonMessageManager.sendNotification(new Notification(NotificationType.PUSH, "send push to you"));

        NotificationManager twitterMessageManager = new NotificationManager(new DumbModerator(), new TwitterCorrector())
                .registerHandler(NotificationType.EMAIL, notification ->
                        System.out.printf((messageTemplate) + "%n", notification.type(), notification.message()))
                .registerHandler(NotificationType.SMS, notification ->
                        System.out.printf((messageTemplate) + "%n", notification.type(), notification.message()))
                .registerHandler(NotificationType.PUSH, notification ->
                        System.out.printf((messageTemplate) + "%n", notification.type(), notification.message()));

        twitterMessageManager.sendNotification(new Notification(NotificationType.EMAIL, "send email to you"));
        twitterMessageManager.sendNotification(new Notification(NotificationType.SMS, "send sms to you"));
        twitterMessageManager.sendNotification(new Notification(NotificationType.PUSH, "send push to you"));

        try {
            twitterMessageManager.sendNotification(
                    new Notification(NotificationType.PUSH, "send push with bad word 1 to you"));
        } catch (IllegalMessageException e) {
            log.warn(e.getMessage());
        }

        try {
            amazonMessageManager.sendNotification(
                    new Notification(NotificationType.EMAIL, "send email with bad word 2 to you"));

        } catch (IllegalMessageException e) {
            log.warn(e.getMessage());
        }

    }
}
