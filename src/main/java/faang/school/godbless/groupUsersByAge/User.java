package faang.school.godbless.groupUsersByAge;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class User {

    private final String name;
    private final int age;
    private final String placeWork;
    private final String address;

    private static final int ADULT_AGE = 18;
    enum VALID_JOBS {Google, Uber, Amazon}
    enum VALID_ADDRESS {London, New_York, Amsterdam}

    public User(String name, int age, VALID_JOBS placeWork, VALID_ADDRESS address) {
        if(!name.isBlank()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException();
        }
        if(age >= ADULT_AGE) {
            this.age = age;
        } else {
            throw new IllegalArgumentException();
        }
        if(VALID_JOBS.valueOf(String.valueOf(placeWork)).equals(placeWork)) {
            this.placeWork = String.valueOf(placeWork);
        } else {
            throw new IllegalArgumentException();
        }
        if(VALID_ADDRESS.valueOf(String.valueOf(address)).equals(address)) {
            this.address = String.valueOf(address);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static HashMap<Integer, List<User>> groupUsers(List<User> list) {
        return (HashMap<Integer, List<User>>) list.stream()
                .collect(Collectors.groupingBy(User::getAge));
    }
}
