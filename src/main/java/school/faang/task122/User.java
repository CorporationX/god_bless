package school.faang.task122;
import lombok.AllArgsConstructor;

import java.util.*;


public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;
    private final static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String workPlace, String address) {

        if (name!=null&&age>=18&&VALID_JOBS.contains(workPlace)&&VALID_ADDRESSES.contains(address)) {
            this.name = name;
            this.age = age;
            this.workPlace = workPlace;
            this.address = address;
        }
        else throw new IllegalArgumentException();
    }

    public int getAge() {
        return age;
    }

    public static Map<Integer,List<User>> groupUsers(List<User> users){
        Map<Integer,List<User>> answer = new HashMap<>();
        for(User user : users){
            answer.computeIfAbsent(user.getAge(), k->new ArrayList<>()).add(user);
        }
        return answer;
    }


}
