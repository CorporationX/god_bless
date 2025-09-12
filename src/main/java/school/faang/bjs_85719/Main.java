package school.faang.bjs_85719;

import java.util.Set;

class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getJob() { return job; }
    public String getAddress() { return address; }

    // константы
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    // Конструктор
    public User(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Некорректное место работы: " + job);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Некорректный адрес: " + address);
        }

        // Если всё ок — сохраняем
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            User u1 = new User("Махмуд Ибн Хаттаб", 25, "Google", "London");
            User u2 = new User("Митхун Чакроботи", 30, "Amazon", "New York");

            System.out.println(u1.getName() + " (" + u1.getAge() + " лет, " + u1.getJob() + ", " + u1.getAddress() + ")");
            System.out.println(u2.getName() + " (" + u2.getAge() + " лет, " + u2.getJob() + ", " + u2.getAddress() + ")");

            // Ошибочный пример
            User u3 = new User("Михалыч", 17, "Uber", "Amsterdam");
            System.out.println(u3.getName() + " (" + u3.getAge() + " лет, " + u3.getJob() + ", " + u3.getAddress() + ")"); // не выполнится

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания пользователя: " + e.getMessage());
        }
    }
}
