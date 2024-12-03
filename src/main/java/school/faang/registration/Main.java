package school.faang.registration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User pasha = new User("Pasha", 32, "Amazon", "Amsterdam");
        User masha = new User("Masha", 5, "Google", "London");
        User dasha = new User("Dasha", 22, "Uber", "Minsk");
        User noName = new User("", 33, "Google", "New York");
        User sasha = new User("Sasha", 22, "Sber", "New York");
    }
}
