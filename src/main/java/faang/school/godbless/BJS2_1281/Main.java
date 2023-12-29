package faang.school.godbless.BJS2_1281;

public class Main {
    public static void main(String[] args) {
        House house = new House("Huge House");

        User user1 = new User("User1", house);
        User user2 = new User("User2", house);
        User user3 = new User("User3", house);
        User user4 = new User("User4", house);

        new Thread(() -> user1.joinHouse(Role.KNIGHT)).start();
        new Thread(() -> user2.joinHouse(Role.MAGE)).start();
        new Thread(() -> user3.joinHouse(Role.LORD)).start();
        new Thread(() -> user4.joinHouse(Role.LORD)).start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> user1.leaveHouse()).start();
        new Thread(() -> user2.leaveHouse()).start();
    }
}