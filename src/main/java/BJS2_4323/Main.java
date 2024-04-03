package BJS2_4323;

public class Main {
    public static void main(String[] args) {
        User userErrorWithName = new User("", 18, "Amazon", "New York");
        User userErrorWithAge = new User("Ilya", 16, "Amazon", "New York");
        User userErrorWithJob = new User("Ilya", 18, "Sber", "New York");
        User userErrorWithAddress = new User("Ilya", 18, "Amazon", "Moscow");
        User correctUser = new User("Ilya", 18, "Amazon", "New York");
    }
}
