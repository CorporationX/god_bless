package faang.school.godbless.age_group;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
public class User {

    private String name;
    private int age;
    private String workplace;
    private String address;

    private static Map<Integer, List<User>> userMap = new HashMap<>();
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");

    public User(String name, int age, String workplace, String address){
        if (name == null){
            throw new UserException(Message.NULL_NAME);
        }
        if (age < 18){
            throw new UserException(Message.UNDERAGE);
        }
        if (!VALID_JOBS.contains(workplace)){
            throw new UserException(Message.WRONG_WORKPLACE);
        }
        if (!VALID_ADDRESSES.contains(address)){
            throw new UserException(Message.WRONG_ADDRESS);
        }

        this.name = name;
        this.workplace = workplace;
        this.address = address;
        this.age = age;
    }

    public static Map<Integer, List<User>> groupUsersByAge(List<User> users){
        for (User user : users){
            List<User> list = userMap.getOrDefault(user.getAge(), new ArrayList<>());
            list.add(user);
            userMap.put(user.getAge(), list);
        }

        return userMap;
    }

    public static void print(){
        for (Map.Entry<Integer, List<User>> entry : userMap.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static int getListSize(int key){

        return userMap.get(key).size();
    }
}

