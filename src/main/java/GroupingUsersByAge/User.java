package GroupingUsersByAge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String workCompany;
    private String address;

    public static Map groupUsers (List<User> users){
        //Создаем мапу, которую выведем в конце метода
        Map groupedUsers = new HashMap<Integer, List<User>>();

        //Создаем временное хранилище для добавления пользователей
        List <User> temp;

        for(User user : users){
            //Получаем доступ к листу по текущему ключу
            temp = (List<User>) groupedUsers.getOrDefault(user.getAge(), new ArrayList<User>());
            temp.add(user);
            groupedUsers.put(user.getAge(), temp);
        }
        return groupedUsers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWorkCompany() {
        return workCompany;
    }

    public void setWorkCompany(String workCompany) {
        this.workCompany = workCompany;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
