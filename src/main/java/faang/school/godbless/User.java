package faang.school.godbless;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public User(String name, int age, String placeOfWork, String address) {
        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    public String getAddress() {
        return address;
    }

    public User() {
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for(User user : users){
            int age = user.getAge();
            if(!groupedUsers.containsKey(age)){
                groupedUsers.put(age, new ArrayList<>());
            }
            groupedUsers.get(age).add(user); // Непосредственно само добавление пользователей по возрасту
        }
        return groupedUsers;
    }


    public String toString(){
        return getName() + ", " + getPlaceOfWork() + ", " + getAddress() + " | "; // Вывод листа нормальными символами
    }


    public static void main(String args[]){
        List<User> users = new ArrayList<>(); // Создание и заполенение листа
        User Person1 = new User("Nikolay", 29, "Moscow", "Pushkinskaya Street 29");
        User Person2 = new User("Maya", 19, "Paris", "Merci Street 91");
        User Person3 = new User("Paul", 29, "Berlin", "Beer Street 34");
        User Person4 = new User("Richard", 35, "London", "Tea Street 12");
        User Person5 = new User("Leo", 24, "Rome", "Pizza Street 78");
        User Person6 = new User("Sergio", 28, "Madrid", "Bull Street 18");
        User Person7 = new User("Marie", 29, "Prague", "Beer Street 14");
        User Person8 = new User("Oliver", 19, "Warsaw", "Bobr Street 62");
        User Person9 = new User("Elizabeth", 24, "Vancouver", "Fish Street 57");
        User Person10 = new User("Jenny", 35, "Washington", "Freedom Street 43");
        users.add(Person1);
        users.add(Person2);
        users.add(Person3);
        users.add(Person4);
        users.add(Person5);
        users.add(Person6);
        users.add(Person7);
        users.add(Person8);
        users.add(Person9);
        users.add(Person10);

        Map<Integer, List<User>> groupedUsers = groupUsers(users); // Создание неотсортированного мапа

        List<Map.Entry<Integer, List<User>>> sortedList = new ArrayList<>(groupedUsers.entrySet()); // Сортировка мапа с помощью листа

        sortedList.sort(Comparator.comparing(Map.Entry::getKey));
        Map<Integer, List<User>> sortedGroupedUsers = new LinkedHashMap<>();

        for(Map.Entry<Integer, List<User>> entry : sortedList){
            sortedGroupedUsers.put(entry.getKey(), entry.getValue()); // Заполнение мапа отсортированными значениями
        }

        for (Map.Entry<Integer, List<User>> entry : sortedGroupedUsers.entrySet()){  // Вывод
        int age = entry.getKey();
        List<User> userList = entry.getValue();
       // String result = users.toString();
        System.out.println("Пользователи с возрастом " + age + ": " + userList);
    }

    }


}
