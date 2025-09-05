package school.faang.bjs2_85516;

public class Main {
    public static void main(String[] args) {
        try {
            User user1 = new User("Artem", 25, "Google", "London");
            User user2 = new User("Olga", 22, "Amazon", "New York");
            User user3 = new User("Oksana", 23, "Uber", "Amsterdam");

            System.out.println("Users created successfully:");
            System.out.println("User 1: " + user1.getName() + ", " + user1.getJob() + ", " + user1.getAddress());
            System.out.println("User 2: " + user2.getName() + ", " + user2.getJob() + ", " + user2.getAddress());
            System.out.println("User 3: " + user3.getName() + ", " + user3.getJob() + ", " + user3.getAddress());

        } catch (IllegalArgumentException e) {
            System.out.println("Error creating user: " + e.getMessage());
        }
        System.out.println("\nTesting invalid users:");

        try {
            new User("", 25, "Google", "London");
        } catch (IllegalArgumentException e) {
            System.out.println("Empty name test: " + e.getMessage());
        }

        try {
            new User("Ruslan", 17, "Google", "London");
        } catch (IllegalArgumentException e) {
            System.out.println("Underage test: " + e.getMessage());
        }

        try {
            new User("Oleg", 25, "Microsoft", "London");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid job test: " + e.getMessage());
        }

        try {
            new User("Anna", 25, "Google", "Paris");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid address test: " + e.getMessage());
        }
    }
}