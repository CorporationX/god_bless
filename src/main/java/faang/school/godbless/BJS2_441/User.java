package faang.school.godbless.BJS2_441;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS= new HashSet<>(Set.of("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES= new HashSet<>(Set.of("London", "New York", "Amsterdam"));
    private int age;
    private String name;
    private String workplace;
    private String address;

    public User(int age, String name, String workplace, String address){
        if(name == null || name.isEmpty() || age<18 || !VALID_JOBS.contains(workplace) || !VALID_ADDRESSES.contains(address)){
            throw new IllegalArgumentException("Validation failed");
        }
        else{
            this.age = age;
            this.name = name;
            this.workplace = workplace;
            this.address = address;
        }

    }
    public static Map<Integer, List<User>> groupUsers(List<User> listOfUsers){
        Map<Integer, List<User>> result = new HashMap<>();
        for (User user : listOfUsers) {
            int key = user.getAge();
            List<User> value = result.getOrDefault(key, new ArrayList<>());
            value.add(user);
            result.put(key, value);
        }
        for (Map.Entry<Integer, List<User>> asd: result.entrySet()) {
            System.out.println(asd.getKey()+": "+asd.getValue());
        }
        return  result;
    }

    public String getAddress() {
        return address;
    }

    public String getWorkplace() {
        return workplace;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String toString(){
        return getAge()+" "+getName()+", "+getWorkplace()+", "+getAddress();
    }
}

