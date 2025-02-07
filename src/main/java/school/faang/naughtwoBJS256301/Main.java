package school.faang.naughtwoBJS256301;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Set<String> hobbySet = Set.of("reading",
                "painting", "gardening", "photography", "hiking", "cooking",
                "knitting", "playing guitar", "birdwatching", "writing");
        List<User> users = new ArrayList<>();
        createUserList(users);
        Map<Integer, String> findHobby = User.findHobbyLovers(users, hobbySet);
        printMap(findHobby);
    }

    private static void printMap(Map<Integer, String> map) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("id " + entry.getKey() + " hobby: " + entry.getValue());
        }
    }

    private static void createUserList(List<User> users) {
        users.add(new User(1, "Viago", 25, new HashSet<>(Set.of("reading", "painting", "gardening"))));
        users.add(new User(2, "Elena", 30, new HashSet<>(Set.of("cooking", "hiking"))));
        users.add(new User(3, "Max", 22, new HashSet<>(Set.of("gaming"))));
        users.add(new User(4, "Svetlana", 34, new HashSet<>(Set.of("yoga", "photography", "traveling"))));
        users.add(new User(5, "Dmitry", 28, new HashSet<>(Set.of("cycling"))));
        users.add(new User(6, "Anna", 19, new HashSet<>(Set.of("dancing", "singing"))));
        users.add(new User(7, "Igor", 40, new HashSet<>(Set.of("fishing", "woodworking"))));
        users.add(new User(8, "Nina", 27, new HashSet<>(Set.of("knitting", "baking"))));
        users.add(new User(9, "Artem", 31, new HashSet<>(Set.of("soccer", "video editing"))));
        users.add(new User(10, "Oksana", 26, new HashSet<>(Set.of("cooking", "reading"))));
        users.add(new User(11, "Vadim", 24, new HashSet<>(Set.of("photography"))));
        users.add(new User(12, "Marina", 35, new HashSet<>(Set.of("traveling", "cooking", "gardening"))));
        users.add(new User(13, "Pavel", 29, new HashSet<>(Set.of("music", "dance"))));
        users.add(new User(14, "Tatiana", 23, new HashSet<>(Set.of("drawing"))));
        users.add(new User(15, "Yuri", 36, new HashSet<>(Set.of("volleyball", "camping"))));
        users.add(new User(16, "Lena", 29, new HashSet<>(Set.of("scrapbooking", "photography"))));
        users.add(new User(17, "Mikhail", 32, new HashSet<>(Set.of("hiking"))));
        users.add(new User(18, "Olga", 21, new HashSet<>(Set.of("blogging", "cooking"))));
        users.add(new User(19, "Sergey", 37, new HashSet<>(Set.of("chess", "guitar"))));
        users.add(new User(20, "Julia", 33, new HashSet<>(Set.of("fitness", "traveling"))));
    }
}
