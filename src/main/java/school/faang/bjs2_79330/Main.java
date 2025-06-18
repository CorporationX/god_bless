package school.faang.bjs2_79330;

public class Main {
    public static void main(String[] args) {
        try {
            User John = new User("", 18, "Google", "London");
            User Petr = new User("Petr", 17, "Uber", "New York");
            User Mary = new User("Mary", 22, "TNT", "Amsterdam");
            User Bob = new User("Bob", 21, "Amazon", "Moscow");
        } catch (IllegalArgumentException e) {

        }
    }
}
