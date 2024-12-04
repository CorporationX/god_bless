package school.faang.task_43982_groupUser;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Setter
@Getter
public class User {
    private String name;
    private Integer age;
    private String workplace;
    private String address;
    private static List<User> users = new ArrayList();

    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }


    public static void main(String[] args) {
        User user1 = new User("Максим",12, "Пивнуха", "ул.Пушкина 1/2");
        User user2 = new User("Игорь",13, "Стрипуха", "ул.Пушкина 1/6");
        User user3 = new User("Валера",14, "Уник", "ул.Пушкина 1/5");
        User user4 = new User("Сергкй",14, "Школа", "ул.Пушкина 1/4");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        Map<Integer, List<User>>  resault = groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry: resault.entrySet()){
            System.out.println("Возраст:" + entry.getKey());
            for (User user: entry.getValue()){
                System.out.printf("Имя: %s, адресс: %s, место работы: %s", user.name, user.address, user.workplace);
                System.out.println();
            }
            System.out.println();
        }

    }

    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer, List<User>> groupAgeUsers = new HashMap();
        for (User user: users){
            if (groupAgeUsers.containsKey(user.age)){
                groupAgeUsers.get(user.age).add(user);
            }
            else{
                List<User> userList = new ArrayList();
                userList.add(user);
                groupAgeUsers.put(user.age, userList);
            }
        }
        return  groupAgeUsers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(workplace, user.workplace) && Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, workplace, address);
    }

}
