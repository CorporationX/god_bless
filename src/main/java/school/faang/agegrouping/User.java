package school.faang.agegrouping;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * Related to JIRA ticket: BJS2-68095
 */
@RequiredArgsConstructor
public class User {
    private final String name;
    @Getter
    private final int age;
    private final String workPlace;
    private final String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        // Stream<User> userStream = users.stream();
        // Collector<User, ?, Map<Integer, List<User>>> groupingCollector = Collectors.groupingBy(User::getAge);
        // Map<Integer, List<User>> groupedUsers = userStream.collect(groupingCollector);
        return users.stream().collect(Collectors.groupingBy(User::getAge));
    }

    @Override
    public String toString() {
        return "name: " + name + " age: " + age + " work place: " + workPlace + " address: " + address;
    }
}