package school.faang.gameOfTrone;

public class Main {
    public static void main(String[] args) {
        House house = new House();
        User user1 = new User("Vlad", "rouge");
        User user2 = new User("Ignat", "paladin");
        User user3 = new User("Jopa", "rouge");

        Thread thread1 = new Thread(() -> {
            user1.joinHouse(house);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ignored) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(ignored.getMessage());
            }
            user1.leaveHouse();
        });
        Thread thread2 = new Thread(() -> {
            user2.joinHouse(house);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ignored) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(ignored.getMessage());
            }
            user2.leaveHouse();
        });
        Thread thread3 = new Thread(() -> {
            user3.joinHouse(house);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ignored) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(ignored.getMessage());
            }
            user3.leaveHouse();
        });

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.err.println("Ошибка ожидания завершения потоков: " + e.getMessage());
            Thread.currentThread().interrupt(); // Восстанавливаем флаг
            throw new RuntimeException(e); // Завершаем выполнение программы
        }
        System.out.println("Все потоки завершены.");
    }
}
