package school.faang.task_43676;

public class Main {
    public static void main(String[] args) {
        tryToCreateUser("NoName", 12, "Google", "New York");
        tryToCreateUser("", 20, "Google", "New York");
        tryToCreateUser("NoName", 20, "What?", "New York");
        tryToCreateUser("NoName", 20, "Google", "What?");
        tryToCreateUser("NoName", 20, "Google", "New York");
    }

    public static void tryToCreateUser(String name, Integer age, String job, String address) {
        try {
            User user = new User(name, age, job, address);
            System.out.printf("User was created, his name is: %s", name);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
