package school.faang.usersgroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Users {
    private String name;
    private Integer age;
    private String workPlace;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Users(String name, int age, String workPlace, String address) {
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", workPlace='" + workPlace + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static Map<Integer,ArrayList<Users>> groupUsers(List<Users> list) {
        Map<Integer, ArrayList<Users>> usersHashMap = new HashMap<>();
        for (Users usersList: list) {
            List<Users> usersArrayList = new ArrayList<>();
            usersArrayList.add(new Users(usersList.getName(), usersList.getAge(), usersList.getWorkPlace(), usersList.getAddress()));

                for (Users secondList: list) { //не знал как по другому сравнить возраст если есть студенты с одинаковым возрастом, сделал цикл
                    if (usersList.getAge().equals(secondList.getAge()) && (!usersList.name.equals(secondList.getName()))) {
                        usersArrayList.add(new Users(secondList.getName(), secondList.getAge(), secondList.getWorkPlace(), secondList.getAddress()));
                    }
                }
            usersHashMap.put(usersList.getAge(), (ArrayList<Users>) usersArrayList);
        }
        return usersHashMap;
    }
}
