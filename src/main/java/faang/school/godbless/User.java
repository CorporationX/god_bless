package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User{
    private String name;
    private Integer year;
    private String department;
    private String adress;

    public User(String name, Integer year, String department, String adress) {
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
