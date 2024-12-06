package school.faang.task_43733;

public class Main {
    public static void main(String[] args) {

        User validUser = new User("Stepashka", 25, "Google", "London");
        System.out.println(validUser.toString());

        try {
            User invalidUser = new User("Stas", 13, "SPACE X", "Texas");
            System.out.println(invalidUser.toString());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
