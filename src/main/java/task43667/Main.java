package task43667;

public class Main {
    public static void main(String[] args) {
        try {
            User user1 = new User("Anton", 16, "Pyterochka", "London");
            User user2 = new User("Anton", 26, "Uber", "New York");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
