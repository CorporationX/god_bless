package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;
    /**
     * Метод принимает список пользователей, создает и заполняет мапу значениями, где
     * ключ-age, значение - пользователь с этим возрастом
     * в циклах итерируемся по map и строим строку с помощью StringBuilder.
     *
     * @param users список пользователей
     */

    public static void groupUser(ArrayList<User> users) {
        Map<Integer, ArrayList<User>> userMap = new HashMap<>();
        StringBuilder result = new StringBuilder();
        for (User user : users) {
            if (!userMap.containsKey(user.getAge())) {
                userMap.put(user.getAge(), new ArrayList<>());
            }
            userMap.get(user.getAge()).add(user);
        }
        for (Map.Entry<Integer, ArrayList<User>> entry : userMap.entrySet()) {
            Integer key = entry.getKey();
            ArrayList<User> userList = entry.getValue();
            for (User user : userList) {
                result.append("| Key: ").append(key)
                        .append("| Name: ").append(user.getName())
                        .append("| Age: ").append(user.getAge())
                        .append("| Work Place: ").append(user.getWorkPlace())
                        .append("| Address: ").append(user.getAddress())
                .append("\n");
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        User andrew = new User("Andrew", 45, "Service", "Novosibirsk");
        User artur = new User("Artur", 35, "Five Group", "Tomsk");
        User angelina = new User("Angelina", 21, "IT-Company", "Moscow");
        User artem = new User("Artem", 45, "Magnet", "Kemerovo");
        User maria = new User("Maria", 21, "AutoService", "Saint-Petersburg");

        users.add(andrew);
        users.add(artur);
        users.add(angelina);
        users.add(artem);
        users.add(maria);
        groupUser(users);
    }
}
