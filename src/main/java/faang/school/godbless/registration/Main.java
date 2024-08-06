package faang.school.godbless.registration;

public class Main {
    public static void main(String[] args) {
        //all correct
        try {
            User user1 = new User("Kate", 20, "Google", "New York");
            System.out.println("User was registered");
        } catch (IllegalArgumentException e) {
            System.out.println("Incorrect user data");
        }
        //empty name
        try {
            User user1 = new User("", 20, "Google", "New York");
            System.out.println("User was registered");
        } catch (IllegalArgumentException e) {
            System.out.println("Incorrect user data");
        }
        //age under 18
        try {
            User user1 = new User("Kate", 16, "Google", "New York");
            System.out.println("User was registered");
        } catch (IllegalArgumentException e) {
            System.out.println("Incorrect user data");
        }
        //incorrect job
        try {
            User user1 = new User("Kate", 20, "Yandex", "New York");
            System.out.println("User was registered");
        } catch (IllegalArgumentException e) {
            System.out.println("Incorrect user data");
        }
        //incorrect address
        try {
            User user1 = new User("Kate", 20, "Google", "Moscow");
            System.out.println("User was registered");
        } catch (IllegalArgumentException e) {
            System.out.println("Incorrect user data");
        }
    }
}
