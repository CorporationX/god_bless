package school.faang;

public class Main {
    public static void main(String[] args) {
        User validUser = new User("Zhanna", 48, "Google", "London");
        System.out.println(validUser);
        User notValidName = new User(" ", 48, "Google", "London");
        User notValidAge = new User("Zhanna", 8, "Google", "London");
        User notValidJob = new User("Zhanna", 8, "OneZero", "London");
        User notValidAddress = new User("Zhanna", 8, "Google", "France");
        System.out.println("test");
    }
}
