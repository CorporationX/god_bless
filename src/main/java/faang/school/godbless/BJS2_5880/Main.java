package faang.school.godbless.BJS2_5880;

public class Main {
    public static void main(String[] args) {
        House house = new House();
        house.getAvailableRoles().put("Smith", 1);
        house.getAvailableRoles().put("Knight", 3);
        house.getAvailableRoles().put("Cook", 1);
        System.out.println(house.getAvailableRoles());

        User user1 = new User("John");
        User user2 = new User("Karl");
        User user3 = new User("Antony");
        User user4 = new User("Jack");
        User user5 = new User("Tacker");


        Thread user1Join = new Thread(() -> user1.joinHouse(house, "Cook"));
        Thread user1Leave = new Thread(() -> user1.leaveHouse(house));
        Thread user2Join = new Thread(() -> user2.joinHouse(house, "Knight"));
        Thread user3Join = new Thread(() -> user3.joinHouse(house, "Knight"));
        Thread user4Join = new Thread(() -> user4.joinHouse(house, "Knight"));
        Thread user5Join = new Thread(() -> user5.joinHouse(house, "Smith"));
        Thread user2Leave = new Thread(() -> user2.leaveHouse(house));
        Thread user3Leave = new Thread(() -> user3.leaveHouse(house));
        Thread user4Leave = new Thread(() -> user4.leaveHouse(house));
        Thread user5Leave = new Thread(() -> user5.leaveHouse(house));

        user1Join.start();
        user2Join.start();
        user5Join.start();
        user3Join.start();
        user4Join.start();
        user1Leave.start();
        user2Leave.start();
        user3Leave.start();
        user4Leave.start();
        user5Leave.start();
    }
}
