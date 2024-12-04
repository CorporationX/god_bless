package school.faang.task_43717;

public class Main {
    public static void main(String[] args) {
        createUser("", 25, "Google", "Amsterdam");
        createUser("Алексей", 17, "Uber", "London");
        createUser("Мария", 30, "ООО Рога и копыта", "New York");
        createUser("Дмитрий", 40, "Amazon", "Калуга");
        createUser("Ольга", 29, "Uber", "Amsterdam");
    }

    private static void createUser(String name, int age, String job, String address) {
        try {
            User user = new User(name, age, job, address);
            System.out.println("Пользователь успешно создан");
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
