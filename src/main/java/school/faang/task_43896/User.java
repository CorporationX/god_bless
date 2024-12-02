package school.faang.task_43896;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;

@Data
public class User {
    String name;
    int age;
    String workplace;
    String address;

    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    static HashMap<Integer, ArrayList<User>> groupUsers(ArrayList<User> users) {
        HashMap<Integer, ArrayList<User>> usersMap = new HashMap<>();

        for (User user : users) {
            if (!usersMap.containsKey(user.getAge())) {
                ArrayList<User> usersList = new ArrayList<>();

                usersList.add(user);
                usersMap.put(user.getAge(), usersList);
            } else {
                ArrayList<User> userArrayList = usersMap.get(user.getAge());

                userArrayList.add(user);
            }
        }

        return usersMap;
    }

    public static void main(String[] args) {
        User user1 = new User("Миша", 36, "Библиотека", "Москва");
        User user2 = new User("Влад", 20, "Завод", "Самара");
        User user3 = new User("Саша", 20, "Фабрика", "Тула");
        User user4 = new User("Вася", 50, "Библиотека", "Тверь");

        ArrayList<User> users = new ArrayList<>();

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        System.out.println(groupUsers(users));
    }
}
