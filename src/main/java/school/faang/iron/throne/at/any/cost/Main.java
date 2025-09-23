package school.faang.iron.throne.at.any.cost;

public class Main {
    public static void main(String[] args) {
        User jon = new User("Jon Snow");
        User ruph = new User("Ruph Snow");
        User lon = new User("Lon Snow");
        House starkHouse = new House();

        starkHouse.addRole("Воин");
        starkHouse.addRole("Стратег");
        starkHouse.addRole("Дипломат");

        Thread t1 = new Thread(() -> {
            try {
                jon.joinHouse(starkHouse);
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                System.err.println("Ошибка в потоке: " + e.getMessage());
                Thread.currentThread().interrupt();
            } finally {
                jon.leaveHouse();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                ruph.joinHouse(starkHouse);
                Thread.sleep(12000);
            } catch (InterruptedException e) {
                System.err.println("Ошибка в потоке: " + e.getMessage());
                Thread.currentThread().interrupt();
            } finally {
                ruph.leaveHouse();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                lon.joinHouse(starkHouse);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.err.println("Ошибка в потоке: " + e.getMessage());
                Thread.currentThread().interrupt();
            } finally {
                lon.leaveHouse();
            }
        });

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.err.println("Ошибка ожидания завершения потоков: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
        System.out.println("Все потоки завершены.");
    }
}
