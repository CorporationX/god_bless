package colletcionOfUsers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> hobbies = new ArrayList<>();
        List<User> users = new ArrayList<>();
        hobbies.add("Программирование");
        hobbies.add("Прогулка");
        User user1 = new User(1L, "Nick", 22, hobbies);
        users.add(user1);

        hobbies = new ArrayList<>();
        hobbies.add("Бег");
        hobbies.add("Рисование");
        User user2 = new User(2L, "Paul", 22, hobbies);
        users.add(user2);

        hobbies = new ArrayList<>();
        hobbies.add("Теннис");
        hobbies.add("Бег");
        hobbies.add("Сериалы");
        User user3 = new User(3L, "Anya", 19, hobbies);
        users.add(user3);

        List<String> activities = Stream.of("Программирование",
                                            "Сериалы", "Теннис").
                        collect(Collectors.toCollection(ArrayList::new));




        for (Map.Entry<User, String> entry : User.findHobbyLovers(users, activities).entrySet()){
            System.out.println("Key = " + entry.getKey());
            System.out.println("Value = " + entry.getValue().toString());
        }
    }
}
