package faang.school.godbless.task1;
import lombok.Data;
import java.util.*;

@Data
public class User {
    private String name;
    private int age;
    private String placeOfWork;
    private String address;
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    public static final int EIGHTEEN = 18;

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> map = new HashMap<>();
        for (User i : userList) {
            int age1 = i.getAge();
            map.putIfAbsent(age1, new ArrayList<>());
            map.get(age1).add(i);
        }
        return map;
    }
    public User(String name, int age, String placeOfWork, String address) {
        if ((name.isEmpty()) || (age < EIGHTEEN) || (!VALID_JOBS.contains(placeOfWork)) || (!VALID_ADDRESSES.contains(address))) {
            /*return*/ throw new IllegalArgumentException();
        } else {
            this.name = name;
            this.age = age;
            this.placeOfWork = placeOfWork;
            this.address = address;
        }
    }
}
