package faang.school.godbless.sprint3.iron_trone;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<String> roles = List.of("Lord", "Knight", "Mage");
        House house = new House("Winterfell", roles, roles.size());

        User user1 = new User("Jon Snow");
        User user2 = new User("Tyrion Lannister");
        User user3 = new User("Daenerys Targaryen");

        user1.joinHouse(house, "Lord");
        System.out.println(user1.getName() + " joined " + user1.getHouse().getName() + " as " + user1.getRole());

        user2.joinHouse(house, "Knight");
        System.out.println(user2.getName() + " joined " + user2.getHouse().getName() + " as " + user2.getRole());

        user3.joinHouse(house, "Mage");
        System.out.println(user3.getName() + " joined " + user3.getHouse().getName() + " as " + user3.getRole());

        user1.leaveHouse(user1.getHouse());
        System.out.println(user1.getName() + " left the house");

        house.addRole("Archer");
        System.out.println("New role added: Archer");
        System.out.println("Available roles: " + house.getAvailableRoles());
    }
}