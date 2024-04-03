package Task3;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int LEGAL_AGE = 18;
    private String name;
    private int age;
    private String address;
    private String placeOfWork;

    public User(String name, int age, String address, String placeOfWork) {
        if (name.isBlank() || age < LEGAL_AGE || !VALID_JOBS.contains(placeOfWork) || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException();
        } else {
            this.name = name;
            this.age = age;
            this.address = address;
            this.placeOfWork = placeOfWork;
        }
    }

    public int age() {
        return age;
    }

    public static Map<Integer, ArrayList<User>> groupUsers(List<User> array) {
        HashMap<Integer, ArrayList<User>> answer = new HashMap<>();
        for (User elem : array) {
            if (!answer.containsKey(elem.age())) {
                ArrayList<User> list = new ArrayList<>();
                answer.put(elem.age(), list);
            }
            answer.get(elem.age()).add(elem);
        }
        return answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(address, user.address) && Objects.equals(placeOfWork, user.placeOfWork);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, address, placeOfWork);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
