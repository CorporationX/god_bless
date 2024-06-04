package faang.school.godbless;

import lombok.Data;
import java.util.*;

@Data
//@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;
    private static final Set <String> VALID_JOBS = new HashSet(Arrays.asList("Google","Uber","Amazon"));
    private static final Set <String> VALID_ADDRESSES = new HashSet(Arrays.asList("London","New York","Amsterdam"));

    public User(String name, int age, String workPlace, String address) throws IllegalArgumentException {
        if (name!=null && age>=18 && VALID_JOBS.contains(workPlace) && VALID_ADDRESSES.contains(address)) {
            this.name = name;
            this.age = age;
            this.workPlace = workPlace;
            this.address = address;
        }
        else throw new IllegalArgumentException();
    }

    public static Map<Integer, List<User>> groupUsers (List<User> users){
        Map<Integer, List<User>> groupedUsersList = new HashMap<>();
        users.forEach(user-> groupedUsersList.computeIfAbsent(user.getAge(), k-> new ArrayList<>()).add(user));
        return groupedUsersList;
    }
}
