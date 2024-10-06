package school.faang.registration;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private static Integer AGE_OF_MAJORITY = 18;

    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) throws IllegalAccessException {
        validateUser(name, age, workplace, address);
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        return userList.stream().collect(Collectors.groupingBy(User::getAge));
    }

    private void validateUser(String name, int age, String workplace, String address) throws IllegalAccessException {
        validateName(name);
        validateAge(age);
        validateWorkplace(workplace);
        validateAddress(address);
    }

    private void validateAddress(String address) throws IllegalAccessException {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalAccessException(String.format("%s не входит в спискок валидных адресов", address));
        }
    }

    private void validateWorkplace(String workplace) throws IllegalAccessException {
        if (!VALID_JOBS.contains(workplace)) {
            throw new IllegalAccessException(String.format("%s не входит в спискок валидных мест работы", workplace));
        }
    }

    private void validateAge(int age) throws IllegalAccessException {
        if (age < AGE_OF_MAJORITY) {
            throw new IllegalAccessException(String.format("Пользователь не должен быть моложе 18 лет! Переданное значение: %s", age));
        }
    }

    private void validateName(String name) throws IllegalAccessException {
        if (name.isEmpty()) {
            throw new IllegalAccessException("Имя пользователя не должно быть пустым");
        }
    }
}
