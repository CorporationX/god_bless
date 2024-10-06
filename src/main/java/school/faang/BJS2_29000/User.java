package school.faang.BJS2_29000;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) throws IllegalAccessException {
        validateName(name);
        validateAge(age);
        validateWorkplace(workplace);
        validateAddress(address);
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        return userList.stream().collect(Collectors.groupingBy(User::getAge));
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
        if (age < 18) {
            throw new IllegalAccessException("Пользователь не должен быть моложе 18 лет");
        }
    }

    private void validateName(String name) throws IllegalAccessException {
        if (name.isEmpty()) {
            throw new IllegalAccessException("Имя пользоваетля не должно бьть пустым");
        }
    }
}
