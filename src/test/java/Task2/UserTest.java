package Task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserTest {
    @Test
    public void testThrowException() {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("", 120, "Amazon", "London"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("Anna", 17, "Amazon", "London"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("Nikita", 18, "Azon", "London"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("Sofia", 119, "Amazon", "Lon"));
    }

    @Test
    public void testGetList() {
        List<User> testUser = new ArrayList<>();

        testUser.add(new User("Nikita", 22, "Uber", "London"));
        testUser.add(new User("Anna", 23, "Uber", "Amsterdam"));
        testUser.add(new User("Sofia", 18, "Google", "London"));

        testUser.add(new User("Anton", 22, "Uber", "Amsterdam"));
        testUser.add(new User("Ben", 23, "Amazon", "London"));
        testUser.add(new User("Maksim", 18, "Amazon", "Amsterdam"));

        Map<Integer, List<User>> map = User.groupUsers(testUser);

        Assertions.assertEquals(testUser.get(0), map.get(22).get(0));
        Assertions.assertEquals(testUser.get(1), map.get(23).get(0));
        Assertions.assertEquals(testUser.get(2), map.get(18).get(0));

        Assertions.assertEquals(testUser.get(3), map.get(22).get(1));
        Assertions.assertEquals(testUser.get(4), map.get(23).get(1));
        Assertions.assertEquals(testUser.get(5), map.get(18).get(1));


    }

    @Test
    public void testGetList2() {
        // Вторая реализация проверки корекного добавление пользователей в список,
        // тут сравниваем объекты по hashCode, чтоб убедится, что они равны.
        // Тест писал не один, Mark помог, самому к такой логике сложно прийти)
        List<User> testUser = new ArrayList<>();

        testUser.add(new User("Nikita", 22, "Uber", "London"));
        testUser.add(new User("Anna", 23, "Uber", "Amsterdam"));
        testUser.add(new User("Sofia", 18, "Google", "London"));
        testUser.add(new User("Anton", 22, "Uber", "Amsterdam"));
        testUser.add(new User("Ben", 23, "Amazon", "London"));
        testUser.add(new User("Maksim", 18, "Amazon", "Amsterdam"));

        Map<Integer, List<User>> map = User.groupUsers(testUser);
        Map<Integer, Integer> attempts = new HashMap<>();

        for (int i = 0; i < testUser.size(); i++) {
            User user = testUser.get(i);
            if (!attempts.containsKey(user.getAge())) {
                attempts.put(user.getAge(), 0);
            } else {
                attempts.put(user.getAge(), attempts.get(user.getAge()) + 1);
            }
            System.out.printf("%s : %d и %d\n", user.getName(), user.hashCode(),
                    map.get(user.getAge()).get(attempts.get(user.getAge())).hashCode());
            Assertions.assertEquals(user, map.get(user.getAge()).get(attempts.get(user.getAge())));
        }

    }
}
