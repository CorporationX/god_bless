package school.faang.bjs248871;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            House house = new House(List.of("Gryffindor", "Slytherin", "Hufflepuff", "Ravenclaw"));

            User user1 = new User("Harry");
            User user2 = new User("Ron");

            user1.joinHouse(house, "Gryffindor");
            user2.joinHouse(house, "Slytherin");
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
}
