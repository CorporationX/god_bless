package school.faang.bjs2_85593_grouping_users;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Геттеры и сеттеры
@Getter
@Setter
@ToString
//Создаем класс пользователя
public class User {
    // Поля класса
    private String name;
    private int age;
    private String workPlace;
    private String address;

    //Конструктор для создания объектов User
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public User(String name, int age, String jobPlace, String address) {
        this.name = name;
        this.age = age;
        this.workPlace = jobPlace;
        this.address = address;
    }
    // Создаю статический метод для группировки пользователей по возрасту
    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        //Шаг1 Проверяем что List<User> не равен null и не пустой
        //Если он null или пустой, вернуть новую, пустую HashMap
        if (users == null || users.isEmpty()) {
            return new HashMap<>();
        }
        //Шаг2 создаем пустую коллекцию Map с ключом age и значением List<User> список пользователей
        Map<Integer, List<User>> groupedUsersMap = new HashMap<>();
        //Шаг3 создаем цикл в котором проходим по каждому User в списке users
        for (User user : users) {
            //Шаг3.1 Проверяем что user существует, имеет имя и возраст >=0
            if (user == null
                    || user.getName() == null
                    || user.getName().isEmpty()
                    || user.getAge() < 0) {
                //Если какая-то из этих проверок не проходит переходим к следующему объекту user
                continue;
            }
            //Шаг3.3 Получаем возраст текущего пользователя
            int age = user.getAge();
            //Шаг3.4 Проверяем содержит ли Map ключ с этим возрастом
            if (groupedUsersMap.containsKey(age)) {
                //Получаем список пользователей с тем же возрастом
                List<User> existingList = groupedUsersMap.get(age);
                //Добавляем в список текущего пользователя
                existingList.add(user);
            } else {
                //Шаг3.5 Если еще нет записей с этим возрастом - создаем новый пустой ArrayList
                List<User> newList = new ArrayList<>();
                //Добавляем в ArrayList запись с текущим пользователем
                newList.add(user);
                //Положим в Map пару (возраст, созданный ArrayList)
                groupedUsersMap.put(age, newList);
            }
        }
        //Шаг4 Возвращаем заполненную HashMap
        return groupedUsersMap;
    }

}
