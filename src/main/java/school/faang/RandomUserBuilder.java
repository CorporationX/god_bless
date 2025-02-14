package school.faang;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

public class RandomUserBuilder {
    private String name = "";
    private final int minAge;
    private final int maxAge;
    private final Set<String> hobbies = new HashSet<>();

    public RandomUserBuilder() {
        this(10, 90);
    }

    public RandomUserBuilder(int minAge, int maxAge) {
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    public RandomUserBuilder addName(String name) {
        this.name = name;

        return this;
    }

    public RandomUserBuilder addHobby(String hobby) {
        hobbies.add(hobby);

        return this;
    }

    public RandomUserBuilder addHobbies(String... hobbies) {
        this.hobbies.addAll(List.of(hobbies));

        return this;
    }

    public User build() {
        if (name.isEmpty()) {
            throw new IllegalStateException("Имя не должно быть пустым");
        }

        if (minAge <= 0) {
            throw new IllegalStateException("Минимальный возраст должен быть больше нуля");
        }

        if (maxAge <= 0) {
            throw new IllegalStateException("Максимальный возраст должен быть больше нуля");
        }

        if (maxAge <= minAge) {
            throw new IllegalStateException("Максимальный возраст должен быть больше минимального");
        }

        Random rnd = new Random();

        return new User(
                UUID.randomUUID(),
                name,
                rnd.nextInt(minAge, maxAge + 1),
                hobbies);
    }
}
