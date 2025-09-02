package school.faang.BJS2_85473;

public class Main {
    public static void main(String[] args) {
        try {
            User user1 = new User("Bob", 15, "Google", "London");
            User user2 = new User("John", 20, "ITMO", "Sbp");
            User user3 = new User("", 20, "Uber", "New York");
            User user4 = new User("Ignat", 16, "School", "Amsterdam");
            User user5 = new User("Marina", 15, "Amazon", "Spb");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
