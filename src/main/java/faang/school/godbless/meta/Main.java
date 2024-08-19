package faang.school.godbless.meta;

public class Main {
    private static final String REPLACER = "*";

    public static void main(String[] args) {
        NotificationManager nm = new NotificationManager();
        nm.registerHandler("push", (notification, detectedSet) -> {
            if (!detectedSet.isEmpty()) {
                detectedSet.forEach(trg -> {
                    String updatedMsg = notification.getMessage().replaceAll(trg, REPLACER.repeat(trg.length()));
                    notification.setMessage(updatedMsg);
                });
            }
            return notification.getMessage();
        });

        nm.registerHandler("sms", (notification, detectedSet) -> {
            String moderatedMsg = notification.getMessage();
            if (!detectedSet.isEmpty()) {
                moderatedMsg = "Moderated notification - detected " + detectedSet.size() + " banned words: " + detectedSet;
            }
            return moderatedMsg;
        });

        nm.registerHandler("email", (notification, detectedSet) -> {
            StringBuilder sb = new StringBuilder();
            sb.append("Last email contained ");
            sb.append(detectedSet.size());
            sb.append(" restricted triggers ");
            sb.append(detectedSet);
            sb.append(". Original content: \n");
            sb.append(notification.getMessage());
            return sb.toString();
        });

        Notification sms = new Notification("sms", "Why do you have to be such a witch all the time?");
        Notification push = new Notification("push", "Only this week, purchase 2 consoles for the price of 1! Don't be late and buy today!");
        Notification email = new Notification("email", "Our team would appreciate it if you could donate or make a purchase to support our efforts, but please ignore anyone who might bitch about your choice.\nSincerely yours, Donations Team");

        nm.sendNotification(sms);
        nm.sendNotification(push);
        nm.sendNotification(email);
    }
}
