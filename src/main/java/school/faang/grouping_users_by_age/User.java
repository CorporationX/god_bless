package school.faang.grouping_users_by_age;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Getter
public class User {
    private static final Set<String> PLACE_OF_WORK = Set.of("Yandex", "Sber", "Aston", "VK");
    private static final Set<String> ADDRESS = Set.of("Moscow", "Saint-Petersburg", "Kazan");

    private String userName;
    private int userAge;
    private String placeOfWork;
    private String address;

    public User(String userName, int userAge, String placeOfWork, String address) {
        if (userName == null || userName.isBlank()) {
            throw new IllegalArgumentException("Имя пользователя не может быть пустым");
        }

        if (userAge <= 0) {
            throw new IllegalArgumentException("Возраст не может быть нулевым или отрицательным");
        }

        if (!PLACE_OF_WORK.contains(placeOfWork)) {
            throw new IllegalArgumentException("Неверное рабочее место");
        }

        if (!ADDRESS.contains(address)) {
            throw new IllegalArgumentException("Неверный адрес");
        }
        this.userName = userName;
        this.userAge = userAge;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }

    public static HashMap<Integer, ArrayList<User>> groupUsers(List<User> users) {
        HashMap<Integer, ArrayList<User>> gropedUsers = new HashMap<>();
        for (User user : users) {
            gropedUsers.computeIfAbsent(user.getUserAge(), age -> new ArrayList<>()).add(user);
        }
        return gropedUsers;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                '}';
    }
}