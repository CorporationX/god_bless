package school.faang.user_registration;

public class Main {

    public static void main(String[] args) {
        try {
            User alice = new User("Alice", 25, "Google", "London");
            System.out.println("Success: " + alice);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            User blank = new User("", 22, "Uber", "New York"); // пустое имя
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            User bob = new User("Bob", 17, "Amazon", "Amsterdam"); // возраст < 18
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            User charlie = new User("Charlie", 30, "Microsoft", "London"); // недопустимая работа
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            User dana = new User("Dana", 28, "Google", "Tokyo"); // недопустимый город
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
