package ru.kraiush.BJS2_34667;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email",
                (notification -> System.out.println("Sending the email: " + notification.getMessage())));

        notificationManager.registerHandler("sms",
                (notification -> System.out.println("Sending SMS: " + notification.getMessage())));

        notificationManager.registerHandler("push",
                (notification -> System.out.println("Sending push-notification: " + notification.getMessage())));

        Notification emailNotification = new Notification("email", "Your email was successfully activated");
        Notification smsNotification = new Notification("sms", "You have successfully changed your password");
        Notification pushNotification = new Notification("push", "New post from: John Doe");
        Notification callNotification = new Notification("call", "Your appointment was scheduled on October 10th");

        try {
            notificationManager.sendNotification(emailNotification);
            notificationManager.sendNotification(smsNotification);
            notificationManager.sendNotification(pushNotification);
            notificationManager.sendNotification(callNotification);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage() + ". Error occurred at: " + Arrays.toString(e.getStackTrace()));
        }
    }
}
