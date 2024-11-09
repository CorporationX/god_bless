package school.faang.meta_universe;

public class Main {
    public static void main(String[] args) {
        notificationmanager nm = new notificationmanager();
        nm.RegisterHandler("email",
                (Notification) -> System.out.println("Email sent: " + Notification.Message)  );
        nm.RegisterHandler("sms",
                (Notification) -> System.out.println("Отправлено SMS: " + Notification.Message)
        );
        nm.RegisterHandler("push",
                (Notification) -> System.out.println("Push notification sent: " + Notification.Message)
        );
        notification n1 = new notification("email", "Your account has been activated");
        notification n2 = new notification("sms", "Password changed successfully");
        notification n3 = new notification("push", "New post from user: JohnDoe");

        nm.SendNotification(n1);
        nm.SendNotification(n2);
        nm.SendNotification(n3);
    }
}
