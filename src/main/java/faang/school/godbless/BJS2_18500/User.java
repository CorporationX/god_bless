package faang.school.godbless.BJS2_18500;

import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private final String name;
    private final int age;
    private final String workPlace;
    private final String address;


    public User(String name, int age, String workPlace, String address) {
        if (name.isBlank() || age < 18 || !VALID_JOBS.contains(workPlace) || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("User: Ошибка инициализации параметров!");
        }

        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", workPlace='" + workPlace + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
