package faang.school.godbless.Sprint_1.JavaBeisic.BJS2_7165;

//1. Создать класс User с полями:
//        id;
//        имя;
//        возраст;
//        множество активностей (строки).
//
//        2. Создать в этом классе метод findHobbyLovers, который принимает список пользователей и множество
//        строк — активности. Возвращает мапу, где ключ пользователь, значение — строка.
//        3. Этот метод должен в переданном списке пользователей находить тех, у кого в ИХ множестве активностей
//        есть хотя бы один элемент из переданного в метод множества активностей. Если так, то сохранить этого
//        пользователя в виде ключа в результирующую мапу, а значением ему выставить первую совпавшую активность
//        в двух множествах.

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<String> user1Activities = new HashSet<>(Set.of("swimming", "reading"));
        Set<String> user2Activities = new HashSet<>(Set.of("hiking", "gaming"));
        Set<String> user3Activities = new HashSet<>(Set.of("swimming", "gaming"));
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Alice", 25, user1Activities));
        users.add(new User(2, "Bob", 30, user2Activities));
        users.add(new User(3, "Charlie", 22, user3Activities));
        Set<String> hobbies = new HashSet<>(Set.of("reading", "gaming"));

        Map<User, String> hobbyLovers = findHobbyLovers(users, hobbies);

        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println("User: " + entry.getKey().getName() + ", Hobby: " + entry.getValue());
        }
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> result = new HashMap<>();
        for (User user : users) {
            for (String hobby : hobbies) {
                if (user.getActivities().contains(hobby)) {
                    result.put(user, hobby);
                    break;
                }
            }
        }
        return result;
    }
}



