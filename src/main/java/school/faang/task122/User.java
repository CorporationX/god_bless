package school.faang.task122;
import lombok.AllArgsConstructor;

import java.util.*;


public class User {
    private final static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private final static int legalAge = 18;

    private String name;
    private int age;
    private String workPlace;
    private String address;

    public User(String name, int age, String workPlace, String address) {

        if (name == null) {
            throw new IllegalArgumentException("Пустое имя");
        }

        if (age < legalAge) {
            throw new IllegalArgumentException("Возраст меньше 18");
        }

        if (!VALID_JOBS.contains(workPlace)) {
            throw new IllegalArgumentException("Не валидное место работы");
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Не валидный адрес работы");
        }

        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
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
