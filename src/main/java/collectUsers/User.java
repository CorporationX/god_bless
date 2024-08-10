package collectUsers;

import lombok.Data;

import java.util.*;

@Data
public class User {
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String firstName;
    private int age;
    private String companyName;
    private String address;

    public User(String firstName, int age, String companyName, String address) throws IllegalArgumentException{

        if(firstName.length()==0) {
            throw new IllegalArgumentException("имя не может быть пустым");
        }
        else if(age<18) {
            throw new IllegalArgumentException("возраст не может быть меньше 18");
        }
        else if(!VALID_JOBS.contains(companyName)) {
            throw new IllegalArgumentException("место работы должно содержаться во множестве VALID_JOBS");
        }
        else if(!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("адрес должен содержаться во множестве VALID_ADDRESSES");
        }
        else {
            this.firstName = firstName;
            this.age = age;
            this.companyName = companyName;
            this.address = address;
        }
    }
    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer,List<User>> group = new HashMap<>();
        for(User user: users){
            if(group.get(user.getAge())==null) {
                List<User> usersByAge = new ArrayList<>();
                usersByAge.add(user);
                group.put(user.getAge(),usersByAge);
            }
            else{
                group.get(user.getAge()).add(user);
            }
        }
        return group;
    }

}
