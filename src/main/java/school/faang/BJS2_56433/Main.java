package school.faang.BJS2_56433;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        User userOne = new User("Artur", 21, "PlaceOne", "AddressOne");
        User userTwo = new User("Timur", 34, "PlaceOne", "AddressOne");
        User userThree = new User("Ernar", 27, "PlaceTwo", "AddressTwo");
        User userFour = new User("Anna", 21, "PlaceTwo", "AddressTwo");
        User userFive = new User("Sofia", 25, "PlaceOne", "AddressOne");

        ArrayList<User> users = new ArrayList<>();
        users.add(userOne);
        users.add(userTwo);
        users.add(userThree);
        users.add(userFour);
        users.add(userFive);

        User.groupUsers(users).forEach((age, user) -> {
            System.out.println(age + ": " + user);
        });
    }

}
