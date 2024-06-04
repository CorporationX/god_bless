package faang.school.godbless;

import java.util.*;

public class User{

    public static final Set VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    public static final Set VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York”", "Amsterdam"));

    private String name;
    private Integer year;
    private String department;
    private String adress;

    public User(String name, Integer year, String department, String adress) {
        if(name == null || year < 18
                || !VALID_JOBS.contains(department)
                || !VALID_ADDRESSES.contains(adress)){
            throw new IllegalArgumentException("not valid");
        }
        this.name = name;
        this.year = year;
        this.department = department;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public Integer getYear() {
        return year;
    }

    public String getDepartment() {
        return department;
    }

    public String getAdress() {
        return adress;
    }

    public static HashMap<String, List<User>> groupUser(List<User> userList){
        HashMap<String, List<User>> userMap = new HashMap<>();

        userList.forEach(user -> {
            if(user.getYear() != null){
                if(userMap.get(user.getYear().toString()) !=null){
                    List userNewList = userMap.get(user.getYear().toString());
                    userNewList.add(user);
                    userMap.put(user.getYear().toString(), userNewList);
                }else{
                    List userNewList = new ArrayList<>();
                    userNewList.add(user);
                    userMap.put(user.getYear().toString(), userNewList);
                }
            }
        });

        return userMap;
    }
}
