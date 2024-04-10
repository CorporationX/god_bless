package faang.school.godbless.Sprint_1.Java_Core.BJS2_4216;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Создать класс
//User со следующими полями:
//имя
//возраст;
//место работы;
//адрес.
//В этом же классе создать статический метод
//groupUsers, который принимает List из объектов User и возвращает Map, где ключом является возраст пользователя,
//а значением — список из всех пользователей в оригинальном списке, которые имеют соответствующий возраст.
public class User {
    private String name;
    private int age;
    private String mestoWork;
    private String adress;
    public User(String name, int age, String mestoWork, String adress) {
        this.name = name;
        this.age = age;
        this.mestoWork = mestoWork;
        this.adress = adress;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMestoWork() {
        return mestoWork;
    }

    public void setMestoWork(String mestoWork) {
        this.mestoWork = mestoWork;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public static Map<Integer, List<User>> groupUsers (List<User> users){
        Map<Integer, List<User>> group = new HashMap<>();
        for (User user : users) {
            int age = user.getAge();
            List<User> userList = group.get(age);
            if(userList == null){
                userList = new ArrayList<>();
            }
            userList.add(user);
            group.put(age, userList);
        }
        return group;
    }
}

