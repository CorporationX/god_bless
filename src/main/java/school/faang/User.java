package school.faang;

public class User {
    private static final int MINIMUM_AGE = 18;

    private String name;
    private int age;
    private Job job;
    private Address address;

    public User(String name, int age, Job job, Address address) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;

        if (name.isEmpty() || name == null) {
            throw new IllegalArgumentException("Имя должно быть заполнено");
        }
        if (age < MINIMUM_AGE) {
            throw new IllegalArgumentException("Минимальный возраст 18 лет");
        }
        if (job == null || address == null) {
            throw new IllegalArgumentException("Поля address и job должно быть заполнено");
        }

    }
}
