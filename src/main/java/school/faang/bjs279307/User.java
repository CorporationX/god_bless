package school.faang.bjs279307;

import java.util.Set;

import lombok.Setter;

@Setter
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESS = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Поле имя не должно быть пустым.");
        }
        this.name = name;

        if (age < 18) {
            throw new IllegalArgumentException("Возраст должен быть 18 или старше.");
        }
        this.age = age;

        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Вы должны работать в Гугл, Убер или Амазон.");
        }
        this.job = job;

        if (!VALID_ADDRESS.contains(address)) {
            throw new IllegalArgumentException("Адрес должен быть Лондон, Нью-Йорк или Амстердам.");
        }
        this.address = address;
    }

    @Override
    public String toString() {
        return "Работник " + name;
    }
}