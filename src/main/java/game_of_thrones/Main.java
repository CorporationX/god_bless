package game_of_thrones;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        House house = new House();
        User user1 = new User("James", "Lannister", house);
        User user2 = new User("Gregory", "Lannister", house);
        user1.joinHouse("Mage");
        user1.leaveHouse();
        user2.joinHouse("Mage");
    }
}
