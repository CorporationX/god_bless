package ru.maks1979.task_46776;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        notificationManager.registerHandler("discord", (notification) -> System.out.println("Sending discord-message" +
                notification.getMessage()));
        notificationManager.registerHandler("telegram", (notification) -> System.out.println("Sending telegram-message" +
                notification.getMessage()));
        notificationManager.registerHandler("watsapp", (notification) -> System.out.println("Sending watsapp-message" +
                notification.getMessage()));
    }
}
