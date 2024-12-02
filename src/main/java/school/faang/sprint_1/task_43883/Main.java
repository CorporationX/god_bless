package school.faang.sprint_1.task_43883;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        var users = new ArrayList<User>();

        users.add(new User("Anna", 21, "Yandex", "Moscow, Paveletskaya, 10"));
        users.add(new User("Sergey", 25, "Sberbank", "Moscow, Kutuzovskaya, 13"));
        users.add(new User("Viktor", 30, "Digital Economy League", "Nizhniy Novgorod, Pervomayskaya, 1"));
        users.add(new User("Tatyana", 22, "Sberbank", "Moscow, Belomorskaya, 12"));
        users.add(new User("Dmitriy", 21, "Roboline", "Dolgoprudny, Dirizhabelnaya, 21"));
        users.add(new User("Irina", 25, "T-Bank", "Dmitrov, Lenina, 5"));
        users.add(new User("Daniil", 25, "RosExport", "Moscow, Molodezhnaya, 11"));

        var groups = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> group : groups.entrySet()) {
            System.out.println("Age: " + group.getKey());

            for (User user : group.getValue()) {
                System.out.println("\t" + user.toString());
            }
        }
    }
}
