package school.faang.task_43631;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workplace;
    private String addres;

    public static Map<Integer, List<User>> groupUsers(List<User> userList){

    }
    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", age=" + age + '\''
                + ", workplace='" + workplace + '\''
                + ", address='" + address + '\'' + '}';
}
