package faang.school.godbless;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
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

    private String name;
    private Long age;
    private String workName;
    private String address;

    public User(String name, Long age, String workName, String address) {
        if(name==null||name.isEmpty()){
            throw new IllegalArgumentException("negative value!");
        }else{
            this.name = name;
        }
        if(age<18){
            throw new IllegalArgumentException("negative value!");
        }else{
            this.age = age;
        }
        if (VALID_JOBS.contains(workName)) {
            this.workName = workName;
        }else{
            throw new IllegalArgumentException("negative value!");
        }
        if (VALID_ADDRESSES.contains(address)) {
            this.address = address;
        }else{
            throw new IllegalArgumentException("negative value!");
        }
    }

//    //Перетруться если возраст одинаковый, но наверное это не важно
//    public static Map<Long, String> groupUsers(List<User> userList){
//        Map<Long, String> map = new HashMap<>();
//        for(User u: userList){
//            map.put(u.age,u.name);
//        }
//        return map;
//    }
}