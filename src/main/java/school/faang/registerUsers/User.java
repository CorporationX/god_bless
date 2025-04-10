package school.faang.registerUsers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int AGE_FOR_REGISTER = 18;

    private String name;
    private int age;
    private String work;
    private String address;

    private User(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.work = builder.work;
        this.address = builder.address;
    }

    public static class Builder {
        private String name;
        private int age;
        private String work;
        private String address;

        public Builder setName(String name) {
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("имя не может быть пустым");
            }
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            if (age < AGE_FOR_REGISTER) {
                throw new IllegalArgumentException("возраст больше %d лет".formatted(AGE_FOR_REGISTER));
            }
            this.age = age;
            return this;
        }

        public Builder setWork(String work) {
            if (!VALID_JOBS.contains(work)) {
                throw new IllegalArgumentException("не подходящее место работы");
            }
            this.work = work;
            return this;
        }

        public Builder setAddress(String address) {
            if (!VALID_ADDRESSES.contains(address)) {
                throw new IllegalArgumentException("не тот город");
            }
            this.address = address;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
