package school.faang.sprint1.bjs_43721;

public class Main {
    public static void main(String[] args) {
        try {
            User validUser = new User("Henry", 41, "Google", "Amsterdam");
            System.out.println(validUser.getName());
            User notValidUser = new User("Scott", 17, "College", "London");
            System.out.println(notValidUser.getName());
        } catch (NullPointerException | IllegalArgumentException exc) {
            System.out.println(exc.getMessage());
        }
    }
}
