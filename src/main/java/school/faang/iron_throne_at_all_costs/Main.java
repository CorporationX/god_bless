package school.faang.iron_throne_at_all_costs;

public class Main {
    public static void main(String[] args) {
        House house1 = new House("House at the Lake-Bakery street");
        User user1 = new User("Lace");
        User user2 = new User("Miro");
        User user3 = new User("Has");
        house1.addRole("Brain");
        house1.addRole("Brave");
        // with threads
        new Thread(() -> user1.joinHouse(house1)).start();
        new Thread(() -> user2.joinHouse(house1)).start();
        new Thread(() -> user3.joinHouse(house1)).start();
        new Thread(() -> user1.leaveHouse(house1)).start();
    }
}
