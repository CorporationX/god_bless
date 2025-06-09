package school.faang.bjs2_79286;

public class Main {
    public static void main(String[] args) {
        User validUser = new User("Vlad", 28, "Uber", "Amsterdam");
        System.out.println(validUser);

        try {
            User invalidUserName = new User("", 18, "Google", "New York");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            User invalidUserAge = new User("Ivan", 17, "Amazon", "London");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            User invalidUserJob = new User("Alex", 19, "Yandex", "Amsterdam");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            User invalidUserAddress = new User("Mike", 20, "Google", "Tokyo");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
