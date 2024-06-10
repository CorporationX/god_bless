package faang.school.godbless.BJS27524;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map

/*
Условия задачи
Создать класс

User со следующими полями:

имя;

возраст;

место работы;

адрес.

В этом же классе создать статический метод

groupUsers, который принимает List из объектов User и возвращает Map, где ключом является возраст пользователя,
а значением — список из всех пользователей в оригинальном списке, которые имеют соответствующий возраст.
 */


public class User {
    private String firstname;
    private int age;
    private String placeofwork;
    private String adds;

    public User(String firstname, int age, String placeofwork, String adds) {
        this.firstname = firstname;
        this.age = age;
        this.placeofwork = placeofwork;
        this.adds = adds;
    }

    public static Map<Integer, List<User>> groupUser(List<User> listOfUser, Set<Integer> newSet) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
            for (User i : listOfUser) {
                groupedUsers.computeIfAbsent(i.getAge(), k -> new ArrayList<>()).add(i);
            }
        return groupedUsers;
    }
}


        


