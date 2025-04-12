package school.faang.userregistration;

public class Main {
    public static void main(String[] args) {
        createUser("Alice", 25, "Google", "London"); // positive
        createUser("Bob", 17, "Amazon", "New York"); // negative age
        createUser("Charlie", 30, "Facebook", "Amsterdam"); // negative job
        createUser("", 22, "Uber", "London"); // negative name isBlank
        createUser("Daisy", 19, "Uber", "Berlin"); // address inValid
        createUser("Evan", 21, "Amazon", "Amsterdam"); // positive
        createUser(null, 28, "Google", "New York"); // name is null
    }

    public static void createUser(String name, int age, String job, String address) {
        try {
            User user = new User(name, age, job, address);
            System.out.println("Создан пользователь: " + user);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка при создании пользователя: " + e.getMessage());
        }
    }
}
