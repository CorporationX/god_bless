package school.faang;

public class Main {
    public static void main(String[] args) {
        try {
            User user = new User("David", 19, "Google", "New York");
            System.out.println("User created: " + user.getName() + ", " + user.getAge() + ", " + user.getJob() + ", " +
                    user.getAddress());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            User user = new User("Eva", 40, "Uber", "London");
            System.out.println("User created: " + user.getName() + ", " + user.getAge() + ", " + user.getJob() + ", " +
                    user.getAddress());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            User user = new User("Paul", 20, "Amazon", "Amsterdam");
            System.out.println("User created: " + user.getName() + ", " + user.getAge() + ", " + user.getJob() + ", " +
                    user.getAddress());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
