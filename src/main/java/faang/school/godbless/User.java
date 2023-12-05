package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private int age;
    private String name;
    private String workplace;
    private String address;
    private static final Set<String> VALID_JOBS= new HashSet<>();
    private static final Set<String> VALID_ADDRESSES= new HashSet<>();

    public User(int age, String name, String workplace, String address){
        VALID_JOBS.add("Google");
        VALID_JOBS.add("Uber");
        VALID_JOBS.add("Amazon");
        VALID_ADDRESSES.add("London");
        VALID_ADDRESSES.add("New York");
        VALID_ADDRESSES.add("Amsterdam");
        if(name.isEmpty() || age<18 || !VALID_JOBS.contains(workplace) || !VALID_ADDRESSES.contains(address)){
            throw new IllegalArgumentException();
        }
        else{
            this.age = age;
            this.name = name;
            this.workplace = workplace;
            this.address = address;
        }

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
}

