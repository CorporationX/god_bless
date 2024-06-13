package GroupingUsersByAge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    String name, work, home;
    int age;

    Map<Integer, List> usersMap = new HashMap<>(); //создаю пустую мапу под людей

    public String toString() {
        String text = "";
        text +=  this.name + " : name, ";
        text +=  this.work + " : work, ";
        text +=  this.home + " : home, ";
        text +=  this.age + " : age ";
        return text;
    }
    public User(String name, String work, String home, int age) {
        this.name = name;              // создаю конструктор для внесения данных в параметр
        this.work = work;
        this.home = home;
        this.age = age;
    }

    void grouping(List<User> users) {   //создаю метод группировки
        for (User user : users) {       // циклом перебираю людей из коллекции лист
            int ageUser = user.age;     //получаю возраст каждого человека из листа
            if (usersMap.containsKey(ageUser)) {  // ставлю условие , где узнаю есть ли в мапе человек заданного возраста
                List<User> spisok = usersMap.get(ageUser); //если такой человек есть, создаю лист spisok в который кладу значение по ключу из мапы
                spisok.add(user);  // добавляю в лист spisok данные нового человека
                usersMap.put(ageUser, spisok); //кладу в мапу по ключу обновлённый лист spisok
            } else {
                List<User> newUser = new ArrayList<>(); //если 32 строчка false и человека по ключу в мапе нет
                newUser.add(user);     //создаю новый лист и кладу в него человека
                usersMap.put(ageUser, newUser);  // кладу в мапу ключ и в значение лист человека
            }
        }
        System.out.println(usersMap); //вывожу мапу на экран
    }
    public static void main(String[] args) {
        User user1 = new User("Bob", "police", " Lenina", 36); // создаю людей из класса User
        User user2 = new User("Pit", "bilder", " Kirova", 36);
        User user3 = new User("Met", "trener", " Sverdlova", 23);
        User user4 = new User("Kail", "student", "Kurchatova", 23);
        User user5 = new User("Nail", "buhgalter", "Lenina", 56);

        List<User> users = new ArrayList<>();
        users.add(user1);   //создаю лист из объектов User
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        user4.grouping(users);  // выполняю метод
    }
}
