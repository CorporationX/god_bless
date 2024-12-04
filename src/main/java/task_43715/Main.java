package task_43715;

public class Main {
    public static void main(String[] args) {
        try {
            User user1 = new User("Artur", 25, "Uber", "London");
            System.out.println(user1);

            User user2 = new User("Ivan", 30, "Amazon", "New York");
            System.out.println(user2);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
