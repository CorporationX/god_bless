import lombok.Getter;

import java.util.*;

@Getter
public class User {

    private static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));

    private String name;
    private int age;
    private String company;
    private String address;

    public User(String name, int age, String company, String address) {
        isEmptyName(name);
        isYounger(age);
        isValidJobs(company);
        isValidAddress(address);

        this.name = name;
        this.age = age;
        this.company = company;
        this.address = address;
    }

    public static void isEmptyName(String name){
        if(name.isEmpty()){
            throw new IllegalArgumentException("Name is empty");
        }
    }
    public static void isYounger(Integer age){
        if(age<18){
            throw new IllegalArgumentException("User is young");
        }
    }
    public static void isValidJobs(String company){
        if(!VALID_JOBS.contains(company)) {
            throw new IllegalArgumentException("Company isn't valid");
        }
    }
    public static void isValidAddress(String address){
        if(!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Address isn't valid");
        }
    }


    private static Map<Integer, List<User>> groupUsers(List<User> arrayUser) {
        Map<Integer, List<User>> arrayUsers = new HashMap<>();
        for (User elementUser : arrayUser) {
            if (arrayUsers.containsKey(elementUser.getAge())) {
                arrayUsers.get(elementUser.getAge()).add(elementUser);
            } else {
                arrayUsers.put(elementUser.getAge(), new ArrayList<>());
                arrayUsers.get(elementUser.getAge()).add(elementUser);
            }
        }
        return arrayUsers;
    }
}