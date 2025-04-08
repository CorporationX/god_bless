package Grouping_by_age_BJS2_67955;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();   //создаем список пользователей
        //вносим пользователей в список
        users.add(new User("Alex", 20, "Theatre", "London"));
        users.add(new User("Sonya", 29, "Mosque", "Budapest"));
        users.add(new User("Margaret", 48, "Hospital", "Los Angeles"));
        users.add(new User("Fred", 20, "Shop", "Vienna"));

        Map<Integer, List<User>> groupedUsers = groupUsers(users); //группируем список пользователей по возрасту

        for (Map.Entry<Integer, List<User>> entry : groupedUsers.entrySet()) { //используем цикл for each, Map.Entry - для итерации сразу по паре ключ - значение, а не по каждому отдельно, entrySet возвращает набор всех пар ключ - значение
            System.out.println("Возраст: " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println("Имя: " + user.getName());
                System.out.println("Место работы: " + user.getWorkplace());
                System.out.println("Адрес: " + user.getAddress());
            }

        }


    }

    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer, List<User>> userGroups = new HashMap<>(); //создаем новую карту для хранения сгруппированных по возрасту пользователей
        for (User user : users) { // используем цикл for each, где User - тип переменной, users - список пользователей, который передается в метод, user - представление текущего элемента при итерации по users
            int age = user.getAge(); //
            if(!userGroups.containsKey(age)){ //проверяем, есть ли список пользователей, сгруппированных по этому возрасту
                userGroups.put(age, new ArrayList<>()); //если такого списка нет, то создаем его (используем ArrayList так как заранее не знаем сколько пользователей будет в конкретном списке)
            }
            userGroups.get(age).add(user); //добавляем пользователя в его возрастную группу
        }
        return userGroups;
    }
}

