package school.faang.bjs2_68202;

import java.util.Set;

public record User(String name, Integer age, String job, String address) {

    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    /**
     * @throws IllegalArgumentException "имя пустое или отсутствует, возраст меньше 18, работа и адрес имеют недопустимые значения"
     */
    public User(String name, Integer age, String job, String address) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
        validateUser(this);
    }

    private static void validateUser(User user) {
        StringBuilder errorMessage = new StringBuilder("Не удалось создать пользователя! Некорректные данные:").append("\n");
        boolean invalidUser = false;
        // Валидация имени
        if (user.name == null) {
            invalidUser = true;
            errorMessage
                    .append("Имя пользователя не может быть null!")
                    .append("\n");
        } else if (user.name.isBlank()) {
            invalidUser = true;
            errorMessage
                    .append("Имя пользователя '%s'. Имя пользователя не может быть пустым!"
                    .formatted(user.name))
                    .append("\n");
        }
        if (user.age < 18) {
            invalidUser = true;
            errorMessage
                    .append("Возраст пользователя: %d. Пользователь должен быть старше 18 лет!"
                    .formatted(user.age))
                    .append("\n");
        }
        if (!VALID_JOBS.contains(user.job)) {
            invalidUser = true;
            errorMessage
                    .append("Пользователь работает в %s. Пользователь должен работать в одной из фирм %s!"
                    .formatted(user.job, VALID_JOBS))
                    .append("\n");
        }
        if (!VALID_ADDRESSES.contains(user.address)) {
            invalidUser = true;
            errorMessage
                    .append("Пользователь проживает в %s. Пользователь должен проживать в одном из городов %s!"
                    .formatted(user.address, VALID_ADDRESSES))
                    .append("\n");
        }
        if (invalidUser) {
            throw new IllegalArgumentException(errorMessage.toString());
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
