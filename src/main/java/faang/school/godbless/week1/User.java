package faang.school.godbless.week1;

import java.util.*;

public class User {
    // Creating class User ( Construction) V1
    private int id;
    private String name;
    private int age;
    private String occupation;
    private String address;

    // Static set for job and adress google and so on V2
    public static final Set<String> VALID_JOBS = new HashSet<>(Set.of("Google", "Uber", "Amazon"));
    public static final Set<String> VALID_ADDRESSES = new HashSet<>(Set.of("London", "New York", "Amsterdam"));
//why when i type VALID does not work but past from copy working??/
    //Constarction with VALIDATION V2

    public User(int id, String name, int age, String occupation, String address) {
        // Making information about User awailable to work with V1

        // VALIDATORS V2
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty. ");
        }
        if (age < 18) {
            throw new IllegalArgumentException(("Age must be 18 or older. "));
        }
        if (!VALID_JOBS.contains(occupation)) {
            throw new IllegalArgumentException("Invalid occupation. Valid jobs are: " + VALID_JOBS);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address. Valid addresses are: " + VALID_ADDRESSES);
        }
        //Constarction V1
        this.id = id;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
        this.address = address;
    }

    //Getters for the fields V1
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getAddress() {
        return address;
    }

    //Making a map hash list to make User in a group and collect them there. V1
    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        // Key for the Hash Map will be the age V1
        for (User user : users) {
            int age = user.getAge();
            groupedUsers.computeIfAbsent(age, k -> new ArrayList<>()).add(user);
        }
        return groupedUsers;
        //Need to work on Map V1

    }

    public static void main(String[] args) {
        //Run the creation list of users V1 up V2
        List<User> users = new ArrayList<>();
        try {
            users.add(new User(1, "Mark", 33, "Google", "London"));
            users.add(new User(2, "Vlad", 30, "Uber", "Amsterdam"));
            users.add(new User(3, "Kany", 25, "Amazon", "New York"));
            users.add(new User(4, "MaxFry", 33, "Google", " New York"));
            //V2 Invalid user job
            users.add(new User(5, "Karl", 25, "Microsoft", "New York"));
        } catch (IllegalArgumentException e) {
            System.err.println("Registration error: " + e.getMessage());
        }
        //V2 Invalid AGE
        try {
            users.add(new User(6,"Melamory",17,"Amazon","London" ));
        } catch (IllegalArgumentException e){
            System.err.println("Registration error: " + e.getMessage());
        }

        //Group users by age V1
        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        // (function)Print out the users by groups V1
        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println("Age; " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println("Name: " + user.getName() + ", Occupation: " + user.getOccupation() + "Address: " + user.getAddress());
            }
            System.out.println();
        }
    }
}
