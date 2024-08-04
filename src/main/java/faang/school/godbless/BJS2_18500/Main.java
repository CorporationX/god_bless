package faang.school.godbless.BJS2_18500;

public class Main {
    public static void main(String[] args) {

        try {
            System.out.println(new User("Alex", 23, "Google", "London"));
            System.out.println(new User("Andrey", 25, "Uber", "Amsterdam"));
            System.out.println(new User("Olga", 27, "Google", "Amsterdam"));
            System.out.println(new User("Kate", 32, "Amazon", "New York"));
            System.out.println(new User("Timur", 28, "Google", "Moscow"));
            System.out.println(new User("Viktor", 25, "Pharmacy", "London"));
            System.out.println(new User("Hektor", 36, "Shop", "London"));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
