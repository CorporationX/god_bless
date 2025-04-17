package school.faang.registration;

public class Main {
    public static void main(String[] args) {
        try {
            User firstUser = new User("Larisa", 30, "Amazon", "Amsterdam");
        } catch (IllegalArgumentException e) {
            System.out.println("Registration failed. " + e.getMessage());
        }
        try {
            User secondUser = new User("", 22, "Uber", "London");
        } catch (IllegalArgumentException e) {
            System.out.println("Registration failed. " + e.getMessage());
        }
        try {
            User thirdUser = new User("Jack", 17, "Google", "New York");
        } catch (IllegalArgumentException e) {
            System.out.println("Registration failed. " + e.getMessage());
        }
        try {
            User fourthUser = new User("Peter", 29, "Facebook", "Paris");
        } catch (IllegalArgumentException e) {
            System.out.println("Registration failed. " + e.getMessage());
        }

    }
}
