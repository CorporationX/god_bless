package faang.school.godbless.Sprint_1.JavaBeisic.BJS2_7574;

//1. Создать класс User со следующими полями:
//        имя;
//        возраст;
//        место работы;
//        адрес
//
//        2. В этом же классе создать статический метод groupUsers, который принимает List из объектов User
//        и возвращает Map, где ключом является возраст пользователя, а значением — список из всех пользователей в
//        оригинальном списке, которые имеют соответствующий возраст.



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Lexa", 18, "Google", "London"));
        userList.add(new User("Dima", 19, "Uber", "New York"));
        userList.add(new User("Vika", 23, "Amazon", "Amsterdam"));
        userList.add(new User("Semen", 23, "Yandex", "Moscow"));
        Map<Integer, List<User>> groupedUsers = groupUsers(userList);
        for (Map.Entry<Integer, List<User>> entry: groupedUsers.entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : userList) {
            int age = user.getAge();
            groupedUsers.putIfAbsent(age, new ArrayList<>());
            groupedUsers.get(age).add(user);
        }
        return groupedUsers;
    }
}


