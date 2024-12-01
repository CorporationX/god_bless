package school.faang.registration;

public class Main {
    public static void main(String[] args) {
        createUser();
        createUserWithWrongAge();
        createUserInvalidAddress();
        createUserInvalidJob();
    }

    private static void createUser() {
        User user = new User("Vasya", 19, "Uber", "New York");
        System.out.println(user);
    }

    private static void createUserWithWrongAge() {
        User user = new User("Peter", 17, "Google", "New York");
        System.out.println(user);
    }

    private static void createUserInvalidJob() {
        User user = new User("Vasya", 19, "Yandex", "New York");
        System.out.println(user);
    }

    private static void createUserInvalidAddress() {
        User user = new User("Vasya", 19, "Google", "Moscow");
        System.out.println(user);
    }
}
