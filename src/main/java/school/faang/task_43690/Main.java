package school.faang.task_43690;

public class Main {
    public static void main(String[] args) {

        try {
            // Корректно
            User user1 = new User("Vadim", 18, "Uber", "Amsterdam");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // Получим value exception: Name cannot be empty
            User userWithEmptyName = new User("", 18, "Uber", "Amsterdam");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            User userNullInAge = new User(null, 18, "Uber", "Amsterdam");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            User userAgeLessThanEighteen = new User("Vadim", 0, "Uber", "Amsterdam");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {

            // Получим value exception: This work is not on the list of allowed
            User userWithTheRightJob = new User("Vadim", 18, "KFC", "Amsterdam");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // Получим value exception: The address is not listed in the allowed list
            User userWithTheWrongAddress = new User("Vadim", 18, "Uber", "Krasnodar");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
