package faang.school.godbless.BJS2_24250;

public class Main {
    public static void main(String[] args) {
        House starkHouse = new House("Старки");
        starkHouse.addRole("Лорд", 1);
        starkHouse.addRole("Рыцарь", 2);

        User user1 = new User("Роб Старк");
        User user2 = new User("Теон Грейджой");
        User user3 = new User("Джон Сноу");

        Thread thread1 = new Thread(() -> {
            user1.joinHouse(starkHouse, "Лорд");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            user1.leaveHouse();
        });

        Thread thread2 = new Thread(() -> {
            user2.joinHouse(starkHouse, "Рыцарь");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            user2.leaveHouse();
        });

        Thread thread3 = new Thread(() -> {
            user3.joinHouse(starkHouse, "Лорд");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            user3.leaveHouse();
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
