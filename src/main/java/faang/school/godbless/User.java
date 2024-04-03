package faang.school.godbless;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public User(String name, int age, String placeOfWork, String address) {
        boolean check = false;
        boolean check2 = false;
        for(String element : VALID_JOBS){
            if(placeOfWork.equals(element)) check = true;
        }
        for(String element : VALID_ADDRESSES){
            if(address.equals(element)) check2 = true;
        }
        if(name.isEmpty()){
            throw new IllegalArgumentException("Имя не может быть пустым");
        } else if (age < 18){
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        } else if(!check2 && !check) {
            throw new IllegalArgumentException("Работа и адрес не входят в список доступных");
        } else if(!check){
            throw new IllegalArgumentException("Работа не входит в список доступных");
        } else if(!check2){
            throw new IllegalArgumentException("Адрес не входит в список доступных");
        }  else {
            this.name = name;
            this.age = age;
            this.placeOfWork = placeOfWork;
            this.address = address;
        }
    }

    static Set<String> VALID_JOBS = new HashSet<>();

    static{
        VALID_JOBS.add("Google");
        VALID_JOBS.add("Uber");
        VALID_JOBS.add("Amazon");
    }

    static Set<String> VALID_ADDRESSES = new HashSet<>();

    static{
        VALID_ADDRESSES.add("London");
        VALID_ADDRESSES.add("New York");
        VALID_ADDRESSES.add("Amsterdam");
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
        User Person1 = new User("Nikolay", 29, "Google", "London");
        User Person2 = new User("Maya", 19, "Google", "New York");
        User Person3 = new User("Paul", 29, "Uber", "London");
        User Person4 = new User("Richard", 35, "Amazon", "Amsterdam");
        User Person5 = new User("Leo", 24, "Amazon", "New York");
        User Person6 = new User("Sergio", 28, "Amazon", "London");
        User Person7 = new User("Marie", 29, "Uber", "New York");
        User Person8 = new User("Oliver", 19, "Google", "Amsterdam");
        User Person9 = new User("Elizabeth", 24, "Uber", "Amsterdam");
        User Person10 = new User("Jenny", 35, "Yandex", "Moscow");
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

