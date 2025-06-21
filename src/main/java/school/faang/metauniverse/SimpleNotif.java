package school.faang.metauniverse;

public class SimpleNotif {
    public static void main(String[] args) {
        NotifManager manager = new NotifManager();

        manager.addHandler(NotifType.EMAIL, n ->
                System.out.println("Отправляем email: " + n.text));

        manager.addHandler(NotifType.SMS, n ->
                System.out.println("Отпраляем SMS: " + n.text));

        manager.addHandler(NotifType.PUSH, n ->
                System.out.println("Отпраляем Push" + n.text));

        manager.send(new Notification(NotifType.EMAIL, "Скинь денег"));
        manager.send(new Notification(NotifType.SMS, "Код 1111"));
        manager.send(new Notification(NotifType.PUSH, "Спам"));
    }
}
