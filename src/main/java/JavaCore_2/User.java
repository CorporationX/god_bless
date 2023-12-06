package JavaCore_2;

import java.util.*;

public class User {

    public User() {}

    public IllegalArgumentException User(String name, int age, String job, String address) {
        if ((!name.equals(" ")) && (!name.equals("")) && (name!=null) && (age>=18) && (VALID_JOBS.equals(job)) && (VALID_ADDRESSES.equals(address))) {
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
        } else
            return new IllegalArgumentException();
        return null;
    }

    private String name;
    private int age;
    private String job;
    private String address;

    private final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer, List<User>> usersGroups = new HashMap<>();
        for (User user: users) {
            if (!(usersGroups.containsKey(user.getAge()))){
                usersGroups.put(user.getAge(), new ArrayList<>());
            }
            usersGroups.get(user.getAge()).add(user);
        }
        return usersGroups;
    }

    public IllegalArgumentException setName(String name) {
        if ((!name.equals(" ")) && (!name.equals("")) && (name!=null))
            this.name = name;
        else
            return new IllegalArgumentException();
        return null;
    }

    public IllegalArgumentException setAge(int age) {
        if (age>=18)
            this.age = age;
        else
            return new IllegalArgumentException();
        return null;
    }

    public IllegalArgumentException setJob(String job) {
        if (VALID_JOBS.equals(job))
            this.job = job;
        else
            return new IllegalArgumentException();
        return null;
    }

    public IllegalArgumentException setAddress(String address) {
        if (VALID_ADDRESSES.equals(address))
            this.address = address;
        else
            return new IllegalArgumentException();
        return null;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getJob() {
        return job;
    }

    public String getAddress() {
        return address;
    }

}