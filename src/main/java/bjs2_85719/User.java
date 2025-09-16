package bjs2_85719;

import java.util.Set;

class User {
    private String name;
    private int age;
    private String job;
    private String address;

    // 2. Статические константы (валидационные наборы)
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    // 3. Конструктор с валидацией
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

    // Для красивого вывода
    @Override
    public String toString() {
        return name + " (" + age + " лет, " + job + ", " + address + ")";
    }
}