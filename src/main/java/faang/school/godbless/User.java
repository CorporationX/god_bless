package faang.school.godbless;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@NonNull
public class User {
    private static final List<String> VALID_JOBS = Collections.unmodifiableList(
            new ArrayList<String>() {{
                add("Google");
                add("Uber");
                add("Amazon");
            }});
    private static final List<String> VALID_ADDRESSES = Collections.unmodifiableList(
            new ArrayList<String>() {{
                add("London");
                add("New York");
                add("Amsterdam");
            }});

    private String Name;
    private Long Age;
    private String WorkName;
    private String Address;

    //Не уверен что правильно применил lombok
    public User(@NonNull String name, Long age, String workName, String address) {
        Name = name;
        Age = AgeTest(age);
        WorkName = WorkNameTest(workName);
        Address = AddressTest(address);
    }

//    public String NameTest(String name){
//        if(name==null){
//            throw new IllegalArgumentException("negative value!");
//        }else{
//            return name;
//        }
//    }

    public Long AgeTest(Long age){
        if(age<18){
            throw new IllegalArgumentException("negative value!");
        }else{
            return age;
        }
    }
    public String WorkNameTest(String workName) {
        if (VALID_JOBS.contains(workName)) {
            return workName;
        }else{
            throw new IllegalArgumentException("negative value!");
        }
    }
    public String AddressTest(String address) {
        if (VALID_ADDRESSES.contains(address)) {
            return address;
        }else{
            throw new IllegalArgumentException("negative value!");
        }
    }

    //Перетруться если возраст одинаковый, но наверное это не важно
    public static Map<Long, String> groupUsers(List<User> userList){
        Map<Long, String> map = new HashMap<>();
        for(User u: userList){
            map.put(u.Age,u.Name);
        }
        return map;
    }
}