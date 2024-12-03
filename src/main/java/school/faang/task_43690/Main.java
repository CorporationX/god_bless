package school.faang.task_43690;

public class Main {
    public static void main(String[] args) {

        // Корректно
        User user1 = new User("Vadim", 18, "Uber", "Amsterdam");

        // Получим value exception: Name cannot be empty
        User user21 = new User("", 18, "Uber", "Amsterdam");
        User user22 = new User(null, 18, "Uber", "Amsterdam");

        // Получим value exception: Age cannot be less than 18
        User user3 = new User("Vadim", 0, "Uber", "Amsterdam");

        // Получим value exception: This work is not on the list of allowed
        User user4 = new User("Vadim", 18, "KFC", "Amsterdam");

        // Получим value exception: The address is not listed in the allowed list
        User user5 = new User("Vadim", 18, "Uber", "Krasnodar");
    }
}
