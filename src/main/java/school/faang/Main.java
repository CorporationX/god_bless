package school.faang;

public class Main {
    public static void main(String[] args) {
        try {
            User user1 = new User("Vlad", 20, "London", "Google");
            System.out.println("New user" + " " + user1.getName() + " " + user1.getAge()
                    + " " + user1.getAddress() + " " + user1.getJob());
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            User user2 = new User("", 20, "London", "Google");
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            User user3 = new User("Vlad", 17, "London", "Google");
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            User user4 = new User("Vlad", 20, "Ekaterinburg", "Google");
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            User user5 = new User("Vlad", 20, "London", "Monetka");
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
