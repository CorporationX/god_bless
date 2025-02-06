package school.faang;

import java.util.Set;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Set<String> hobbySet = new LinkedHashSet<>(Set.of("reading", "painting", "gardening", "photography", "hiking", "cooking", "knitting", "playing guitar", "birdwatching", "writing"));
        List<User> users = new ArrayList<>();
        addMyUser(users);
        Map<Integer, String> findHobby = User.findHobbyLovers(users, hobbySet);
        printMap(findHobby);
    }

    private static void printMap(Map<Integer, String> map) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("id " + entry.getKey() + " hobby: " + entry.getValue());
        }
    }

    private static void addMyUser(List<User> users) {
        users.add(new User(1, "Viago", 25, new LinkedHashSet<>(Set.of("reading", "painting", "gardening"))));
        users.add(new User(2, "Elena", 30, new LinkedHashSet<>(Set.of("cooking", "hiking"))));
        users.add(new User(3, "Max", 22, new LinkedHashSet<>(Set.of("gaming"))));
        users.add(new User(4, "Svetlana", 34, new LinkedHashSet<>(Set.of("yoga", "photography", "traveling"))));
        users.add(new User(5, "Dmitry", 28, new LinkedHashSet<>(Set.of("cycling"))));
        users.add(new User(6, "Anna", 19, new LinkedHashSet<>(Set.of("dancing", "singing"))));
        users.add(new User(7, "Igor", 40, new LinkedHashSet<>(Set.of("fishing", "woodworking"))));
        users.add(new User(8, "Nina", 27, new LinkedHashSet<>(Set.of("knitting", "baking"))));
        users.add(new User(9, "Artem", 31, new LinkedHashSet<>(Set.of("soccer", "video editing"))));
        users.add(new User(10, "Oksana", 26, new LinkedHashSet<>(Set.of("cooking", "reading"))));
        users.add(new User(11, "Vadim", 24, new LinkedHashSet<>(Set.of("photography"))));
        users.add(new User(12, "Marina", 35, new LinkedHashSet<>(Set.of("traveling", "cooking", "gardening"))));
        users.add(new User(13, "Pavel", 29, new LinkedHashSet<>(Set.of("music", "dance"))));
        users.add(new User(14, "Tatiana", 23, new LinkedHashSet<>(Set.of("drawing"))));
        users.add(new User(15, "Yuri", 36, new LinkedHashSet<>(Set.of("volleyball", "camping"))));
        users.add(new User(16, "Lena", 29, new LinkedHashSet<>(Set.of("scrapbooking", "photography"))));
        users.add(new User(17, "Mikhail", 32, new LinkedHashSet<>(Set.of("hiking"))));
        users.add(new User(18, "Olga", 21, new LinkedHashSet<>(Set.of("blogging", "cooking"))));
        users.add(new User(19, "Sergey", 37, new LinkedHashSet<>(Set.of("chess", "guitar"))));
        users.add(new User(20, "Julia", 33, new LinkedHashSet<>(Set.of("fitness", "traveling"))));

    }
}
