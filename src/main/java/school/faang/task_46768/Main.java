package school.faang.task_46768;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();

        Notification voiceNotification = new Notification("voice", "Come on! Let's go!");
        Notification smsNotification = new Notification("sms", "Your credit card is blocked!");
        Notification discordNotification = new Notification("discord", "Let's do PP!");

        manager.registerHandler("voice", notification -> System.out.println("Yell loud: "
                + notification.getMessage()));

        manager.registerHandler("sms", notification -> System.out.println("Send sms: "
                + notification.getMessage()));

        manager.sendNotification(voiceNotification);
        manager.sendNotification(smsNotification);
        manager.sendNotification(discordNotification);
    }
}
