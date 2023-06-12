package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Mikhail", 19, "school", "Madrid"));
        users.add(new User("Oleg", 23, "IT", "Minsk"));
        users.add(new User("Anton", 20, "university", "Warsaw"));
        users.add(new User("Vlad", 17, "sport", "Moscow"));
        users.add(new User("Liza", 28, "PM", "Barcelona"));
    }
}