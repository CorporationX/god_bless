package school.faang.userRegistration;

public class Main {
    public static void main(String[] args) {
        try {
            User user = new User("David", 19, "Google", "New York");
            System.out.println(formatUser(user));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            User user = new User("Eva", 40, "Uber", "London");
            System.out.println(formatUser(user));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            User user = new User("Paul", 20, "Amazon", "Amsterdam");
            System.out.println(formatUser(user));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static String formatUser(User user) {
        return new StringBuilder("User created: ")
                .append("Name = ").append(user.getName())
                .append(", Age = ").append(user.getAge())
                .append(", Job = ").append(user.getJob())
                .append(", Aggress = ").append(user.getAddress())
                .toString();
    }
}
