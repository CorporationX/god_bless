package school.faang.sprint1.BJS2_56517;

public class Main {
    public static void main(String[] args) {
        try {
            User user = new User(null, 18, "Uber", "London");
            User user1 = new User("Alina", 19, "Uber", "Amsterdam");
            User user2 = new User("King", 18, "Google", "London");
            User user3 = new User("Maksim", 25, "Amazon", "New York");

        } catch (IllegalArgumentException e) {
            System.out.println("ошибка");
        }
    }
}
