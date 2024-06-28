package faang.school.godbless.NotificationFacebook;

public class Main {
    private static final int COUNT_NOTIFICATION = 10;

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        notificationManager.finalNot(COUNT_NOTIFICATION);
        notificationManager.shutdownCall();
        notificationManager.getAllNotifications().forEach(System.out::println);
    }
}
