package faang.school.godbless.BJS224422;

public class Main {
    public static void main(String[] args) {
        House starkHouse = new House();
        starkHouse.addRole("Lord");
        starkHouse.addRole("Knight");
        starkHouse.addRole("Mage");

        User user1 = new User();
        user1.setUserName("Jon Snow");
        user1.setHouse(starkHouse);
        user1.setRole("Lord");

        User user2 = new User();
        user2.setUserName("Arya Stark");
        user2.setHouse(starkHouse);
        user2.setRole("Knight");

        User user3 = new User();
        user3.setUserName("Bran Stark");
        user3.setHouse(starkHouse);
        user3.setRole("Mage");

        User user4 = new User();
        user4.setUserName("Sansa Stark");
        user4.setHouse(starkHouse);
        user4.setRole("Lord"); // Эта роль уже занята Jon Snow, поэтому Sansa должна будет ждать

        Thread thread1 = new Thread(() -> {
            try {
                user1.joinHouse();
                Thread.sleep(3000);  // Симулируем время нахождения в доме
                user1.leaveHouse();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                user2.joinHouse();
                Thread.sleep(2000);  // Симулируем время нахождения в доме
                user2.leaveHouse();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                user3.joinHouse();
                Thread.sleep(1000);  // Симулируем время нахождения в доме
                user3.leaveHouse();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread thread4 = new Thread(() -> {
            try {
                user4.joinHouse();  // Этот поток должен ждать, пока Jon Snow не освободит роль
                Thread.sleep(1000);  // Симулируем время нахождения в доме
                user4.leaveHouse();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Все пользователи завершили свои действия.");
    }
}
