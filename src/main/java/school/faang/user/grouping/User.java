package school.faang.user.grouping;

import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class User {
    private String name;
    private byte age;
    private String workplace;
    private String address;

    public static Map<Byte, List<User>> groupUsers(List<User> users) {
        HashMap<Byte, List<User>> groupByAge = new HashMap<>();
        for (User user : users) {
            groupByAge.computeIfAbsent(user.getAge(), age -> new ArrayList<>()).add(user);
        }
        return groupByAge;
    }

    public static void main(String[] args) {
        User testUser1 = new User("Iya", (byte) 24, "AviaBriefing", "Saint Petersburg");
        User testUser2 = new User("Barbie", (byte) 24, "Barbie", "Random House");
        User testUser3 = new User("Ken", (byte) 25, "Ken", "Random House");
        System.out.println(User.groupUsers(List.of(testUser1, testUser2, testUser3)));
    }
}
