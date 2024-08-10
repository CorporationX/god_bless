package collectUsers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    protected static List<User> users = new ArrayList<>();
    public static void main (String[] args) {

    createUser("Andrey", 33, "Home", "Moscow");
    createUser("Sabina", 17, "Sber", "Moscow");
    createUser("Elon", 53, "Tesla", "USA");
    createUser("Incognito", 33, "Google", "Moscow");
    createUser("",20,"Google", "London");
    createUser("IdealUser", 20, "Google", "London");


    Map<Integer, List<User>> group = User.groupUsers(users);
    System.out.println("В мапе находятся следующие пользователи:");
    for(Map.Entry<Integer, List<User>> entry: group.entrySet()){
        for(User user: entry.getValue()){
                    System.out.println("Возраст: " + entry.getKey() + ". имя: " + user.getFirstName() + ". Место работы: " + user.getCompanyName() + ". Адрес: " + user.getAddress());
        }
    }
    }
    static void createUser(String name, int age, String companyName, String address) throws IllegalArgumentException {
        try {
            User newUser = new User(name, age, companyName, address);
            users.add(newUser);
        }
        catch (Exception e){
            System.out.println("Создаем пользователя - имя: " + name + ". Возраст: " + age+ ". Место работы: " +companyName+ ". Адрес: " +address+ ". Ошибка валидации: " + e.getMessage());

        }
    }

}
