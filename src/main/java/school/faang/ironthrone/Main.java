package school.faang.ironthrone;

public class Main {
    public static void main(String[] args) {

        House house1 = new House("house1");

        User user1 = new User("user1");
        User user2 = new User("user");
        User user3 = new User("user3");

        Thread t1 = new Thread(() -> {
            user1.joinHouse(house1);
            try {
                Thread.sleep(house1.getSleep1());
            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            } finally {
                user1.leaveHouse();
            }
        });

        Thread t2 = new Thread(() -> {
            user2.joinHouse(house1);
            try {
                Thread.sleep(house1.getSleep3());
            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            } finally {
                user2.leaveHouse();
            }
        });

        Thread t3 = new Thread(() -> {
            user3.joinHouse(house1);
            try {
                Thread.sleep(house1.getSleep2());
            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            } finally {
                user3.leaveHouse();
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
            throw new RuntimeException(e);
        }
    }
}
