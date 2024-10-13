package school.faang.bjs2_31996;

import java.util.*;

//1.1 Task
public class User {
    private String name;
    private int age;
    private String occupation;
    private String address;

    //Task 2.2

    public static final Set<String> VALID_JOBS = new HashSet<>();
    public static final Set<String> VALID_ADDRESSES = new HashSet<>();

    static {
        VALID_JOBS.add("Google");
        VALID_JOBS.add("Uber");
        VALID_JOBS.add("Amazon");

        VALID_ADDRESSES.add("London");
        VALID_ADDRESSES.add("New York");
        VALID_ADDRESSES.add("Amsterdam");
    }


    //Construct 2.1 Task and 2.3
    public User(String name, int age, String occupation, String address) {
        setName(name);
        setAge(age);
        setOccupation(occupation);
        setAddress(address);
    }

    //Getters
    public String getName() {

        return name;
    }

    public Integer getAge() {

        return age;
    }

    public String getOccupation() {

        return occupation;
    }

    public String getAddress() {

        return address;
    }

    //Setters 2.3 Validation
    public void setName(String name) {
        if (name ==null|| name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.name = name;
    }

    public void setAge(Integer age) {
        if(age == null||age<18){
            throw new IllegalArgumentException("Age annot be less then 18");
        }
        this.age = age;
    }

    public void setOccupation(String occupation) {
        if(occupation == null||!VALID_JOBS.contains(occupation)){
            throw new IllegalArgumentException("Invalid occupation "+ occupation);
        }
        this.occupation = occupation;
    }

    public void setAddress(String address) {
        if(address == null||!VALID_ADDRESSES.contains(address)){
            throw new IllegalArgumentException("Invalid address "+ address);
        }
        this.address = address;
    }

    //1.2 Task
    public static Map<Integer, List<User>> groupUsers(List<User> users) {

        Map<Integer, List<User>> map = new HashMap<>();


        for (User user : users) {
            int age = user.getAge();

            if (!map.containsKey(age)) {
                map.put(age, new ArrayList<>());
            }

            map.get(age).add(user);
        }
        return map;
    }
//123
}
