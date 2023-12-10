package faang.school.godbless.UserRegistration;

import lombok.Getter;
import lombok.ToString;

import java.util.*;

@Getter
@ToString
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;
    private final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));

    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer, List<User>> usersMap = new HashMap<>();
        for(User user: users){
            int key = user.getAge();
            if(!usersMap.containsKey(key)){
                usersMap.put(key, new ArrayList<>());
            }
            usersMap.get(key).add(user);
        }
        for(Map.Entry<Integer, List<User>> entry: usersMap.entrySet()){
            System.out.println("Ключ: " + entry.getKey() + " Значение: " + entry.getValue());
        }
        return usersMap;
    }

    public User(String name, int age, String workplace, String address) {
        if (name.isEmpty() || name == null || age < 18 || !VALID_JOBS.contains(workplace) || !VALID_ADDRESSES.contains(address)){
            throw new IllegalArgumentException("Введены неверные данные");
        }
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }
}