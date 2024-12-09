package CendalJoe_BJS2_44009;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getWorkplace() {
        return workplace;
    }

    public String getAddress() {
        return address;
    }

    static Map <Integer, List<User>> groupUsers (List <User> UserList) {
        Map <Integer, List<User>> UserSelect = new HashMap<>();
        for (User CheckUser : UserList) {
            if ( UserSelect.containsKey ( CheckUser.getAge() ) == false) {
                List <User> LocalUserList = new ArrayList<>();
                UserSelect.put ( CheckUser.getAge(), LocalUserList);
                LocalUserList.add ( CheckUser );
            }else{
                
            }
        }
        return UserSelect;
    }
}
//пустая МАП. циклом проверка на ключ. ПУстой ЛИСТ.
// вставлять нужных студентов в Лист и добавить ЛИСТ в ЗНАЧЕНИЕ