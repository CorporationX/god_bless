package school.faang.hobby;

import java.util.List;
import java.util.Set;

public class Main {
    private static final Set<String> BEST_HOBBY = Set.of("Tennis", "Yoga");

    public static void main(String[] args) {
        Set<String> hobbyOne = Set.of("Futtbol, Basketbol", "Tennis");
        Set<String> hobbyTwo = Set.of("Book, Basketbol", "Computer");
        Set<String> hobbyThree = Set.of("Volleyboll", "Tennis", "Yoga");

        Users userOne = new Users(1, "oleg", 23, hobbyOne);
        Users userTwo = new Users(2, "igor", 45, hobbyTwo);
        Users userThree = new Users(3, "olga", 34, hobbyThree);
        List<Users> usersList = List.of(userOne, userThree, userTwo);

        System.out.println(Users.findHobbyLovers(usersList, BEST_HOBBY));
    }
}
