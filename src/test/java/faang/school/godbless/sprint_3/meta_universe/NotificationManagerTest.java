package faang.school.godbless.sprint_3.meta_universe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class NotificationManagerTest {
    NotificationManager notificationManager;
    ByteArrayOutputStream outputStream;
    Notification emailNotification;
    Notification smsNotification;
    Notification crack;
    Notification adidas;
    Consumer<Notification> emailConsumer;
    Consumer<Notification> smsConsumer;
    Predicate<Notification> firstPredicate;
    Predicate<Notification> secondPredicate;

    @BeforeEach
    public void init() {
        notificationManager = new NotificationManager();
        emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        smsNotification = new Notification("sms", "Ваш номер телефона успешно привязан");
        emailConsumer = (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage());
        smsConsumer = (notification) -> System.out.println("Отправка за номером телефона: " + notification.getMessage());
        firstPredicate = notification -> notification.getMessage().contains("adidas");
        secondPredicate = notification -> notification.getMessage().contains("crack.com");
        crack = new Notification("crack.com", "Заходите на наш сайт с самыми новыми читами crack.com");
        adidas = new Notification("adidas", "Только сегодня можно купить кроссовки adidas по скидке!");
        outputStream = new ByteArrayOutputStream();
    }

    @Test
    public void registerHandlerTest() {

        notificationManager.registerHandler("email", emailConsumer);
        notificationManager.registerHandler("sms", smsConsumer);

        Consumer<Notification> firstExpected = emailConsumer;
        Consumer<Notification> secondExpected = smsConsumer;

        Consumer<Notification> firstResult = notificationManager.getNotificationsList().get("email");
        Consumer<Notification> secondResult = notificationManager.getNotificationsList().get("sms");
        assertEquals(firstExpected, firstResult);
        assertEquals(secondExpected, secondResult);
        assertTrue(notificationManager.getNotificationsList().containsKey("email"));
        assertTrue(notificationManager.getNotificationsList().containsKey("sms"));
        assertEquals(2, notificationManager.getNotificationsList().size());
        assertFalse(notificationManager.notificationsList.containsKey("adidas"));
    }

    @Test
    public void sendNotificationTest() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        notificationManager.registerHandler("sms", smsConsumer);
        notificationManager.registerHandler("email", emailConsumer);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(emailNotification);

        String smsExpected = "Отправка за номером телефона: Ваш номер телефона успешно привязан";
        String emailExpected = "Отправка по электронной почте: Ваша учетная запись успешно активирована";
        String result = outputStream.toString().trim();

        assertTrue(result.contains(smsExpected));
        assertTrue(result.contains(emailExpected));
    }

    @Test
    public void filteredNotificationTest() {
        notificationManager.filteredNotifications(firstPredicate);
        notificationManager.filteredNotifications(secondPredicate);

        Predicate<Notification> firstExpected = firstPredicate;
        Predicate<Notification> secondExpected = secondPredicate;

        assertTrue(notificationManager.getPredicatesList().contains(firstExpected));
        assertTrue(notificationManager.getPredicatesList().contains(secondExpected));
        assertEquals(2, notificationManager.getPredicatesList().size());
    }

    @Test
    public void filterTest() {
        System.setOut(new PrintStream(outputStream));

        notificationManager.filteredNotifications(firstPredicate);
        notificationManager.filteredNotifications(secondPredicate);

        notificationManager.filter(adidas);
        notificationManager.filter(crack);
        notificationManager.filter(emailNotification);


        String firstExpected = "Ваше сообщение имеет запрещенное слово: crack.com";
        String secondExpected = "Ваше сообщение имеет запрещенное слово: adidas";
        String thirdExpected = "Ваше сообщение имеет запрещенное слово: email";

        String result = outputStream.toString().trim();

        assertTrue(result.contains(firstExpected));
        assertTrue(result.contains(secondExpected));
        assertFalse(result.contains(thirdExpected));
    }
}