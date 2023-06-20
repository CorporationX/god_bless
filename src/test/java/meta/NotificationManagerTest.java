package meta;

import faang.school.godbless.meta.Consumer;
import faang.school.godbless.meta.Notification;
import faang.school.godbless.meta.NotificationManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NotificationManagerTest {
  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
  NotificationManager notificationManager;

  @BeforeEach
  public void setUp() {
    notificationManager = new NotificationManager();
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @Test
  public void registerHandlerTest() {
    notificationManager.registerHandler("email", (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
    notificationManager.registerHandler("sms", (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()));
    notificationManager.registerHandler("push", (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));

    Map<String, Consumer<Notification>> mapTypeToHandler = notificationManager.getMapTypeToHandler();

    assertTrue(mapTypeToHandler.containsKey("email"));
    assertTrue(mapTypeToHandler.containsKey("sms"));
    assertTrue(mapTypeToHandler.containsKey("push"));
  }

  @Test
  public void sendNotificationTest() {
    notificationManager.registerHandler("email", (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
    notificationManager.registerHandler("sms", (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()));
    notificationManager.registerHandler("push", (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));

    Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
    Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
    Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

    notificationManager.sendNotification(emailNotification);
    assertEquals("Отправка по электронной почте: Ваша учетная запись успешно активирована", outputStreamCaptor.toString()
        .trim());

    outputStreamCaptor.reset();

    notificationManager.sendNotification(smsNotification);
    assertEquals("Отправка SMS: Вы успешно изменили свой пароль", outputStreamCaptor.toString()
        .trim());
    outputStreamCaptor.reset();

    notificationManager.sendNotification(pushNotification);
    assertEquals("Отправка push-уведомления: Новый пост от пользователя: JohnDoe", outputStreamCaptor.toString()
        .trim());

    outputStreamCaptor.reset();
  }
}