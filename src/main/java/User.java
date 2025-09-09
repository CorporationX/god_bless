import java.util.Set;

public class User {
    public final String name;
    public final int age;
    public final String job;
    public final String address;

    // Статические константы (наборы допустимых значений)
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    // Конструктор с валидацией
    public User(String name, int age, String job, String address) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        }
        if (job == null || !VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Недопустимое место работы: " + job);
        }
        if (address == null || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Недопустимый адрес: " + address);
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + ", job='" + job + "', address='" + address + "'}";
    }

    // Демонстрация использования
    public static void main(String[] args) {
        try {
            User u1 = new User("Alice", 30, "Google", "London");
            System.out.println("Создан пользователь: " + u1);
        } catch (IllegalArgumentException ex) {
            System.err.println("Ошибка при создании пользователя: " + ex.getMessage());
        }

        // Пример ошибки: пустое имя
        try {
            User u2 = new User("   ", 25, "Google", "London");
        } catch (IllegalArgumentException ex) {
            System.err.println("Ожидаемая ошибка (имя): " + ex.getMessage());
        }

        // Пример ошибки: возраст < 18
        try {
            User u3 = new User("Bob", 16, "Amazon", "New York");
        } catch (IllegalArgumentException ex) {
            System.err.println("Ожидаемая ошибка (возраст): " + ex.getMessage());
        }

        // Пример ошибки: недопустимая работа
        try {
            User u4 = new User("Carol", 28, "Facebook", "Amsterdam");
        } catch (IllegalArgumentException ex) {
            System.err.println("Ожидаемая ошибка (работа): " + ex.getMessage());
        }

        // Пример ошибки: недопустимый адрес
        try {
            User u5 = new User("Dave", 40, "Uber", "Paris");
        } catch (IllegalArgumentException ex) {
            System.err.println("Ожидаемая ошибка (адрес): " + ex.getMessage());
        }
    }
}

