package user.registration;

public class Main {
    public static void main(String[] args) {
        checkUserCreation("", 24, "Google", "New York");
        checkUserCreation("Kolya", 17, "Amazon", "London");
        checkUserCreation("Katya", 21, "Yandex", "Amsterdam");
        checkUserCreation("Slava", 24, "Google", "Montreal");
        checkUserCreation("", 15, "Kaspersky", "Moscow");
        checkUserCreation("Sveta", 25, "Uber", "Amsterdam");
    }

    private static void checkUserCreation(String name, int age, String workPlace, String address) {
        try {
            new User(name, age, workPlace, address);
            System.out.println("User created!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
