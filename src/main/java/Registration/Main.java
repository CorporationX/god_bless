package Registration;

public class Main {
    public static void main(String[] args) {
        User user = new User("Peter", 18, "Uber", "London");
        User userWithoutName = new User("", 18, "Uber", "London");
        User userWithWrongAge = new User("Peter", 2, "Uber", "London");
        User userWithWrongWorkCompany = new User("Peter", 18, "Ubbber", "London");
        User userWithWrongAddress = new User("Peter", 18, "Uber", "Pondon");

    }
}
