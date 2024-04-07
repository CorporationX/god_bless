package Task3;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Getter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@EqualsAndHashCode
@ToString
@Getter
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int LEGAL_AGE = 18;
    private String name;
    private int age;
    private String address;
    private String placeOfWork;

    public User(String name, int age, String address, String placeOfWork) {
        validateValues(name, age, address, placeOfWork);
        this.name = name;
        this.age = age;
        this.address = address;
        this.placeOfWork = placeOfWork;

    }

    public static Map<Integer, ArrayList<User>> groupUsers(List<User> array) {
        HashMap<Integer, ArrayList<User>> answer = new HashMap<>();
        for (User elem : array) {
            if (!answer.containsKey(elem.getAge())) {
                ArrayList<User> list = new ArrayList<>();
                answer.put(elem.getAge(), list);
            }
            answer.get(elem.getAge()).add(elem);
        }
        return answer;
    }

    private static void validateValues(String name, int age, String address, String placeOfWork) {
        if(name == null){
            throw new IllegalArgumentException("Name is null");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name is blank");
        }
        if (age < LEGAL_AGE) {
            throw new IllegalArgumentException("Unacceptable age");
        }
        if (!VALID_JOBS.contains(placeOfWork)) {
            throw new IllegalArgumentException("Invalid place of work");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address");
        }
    }
}
