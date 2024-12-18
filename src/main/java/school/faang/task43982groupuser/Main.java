package school.faang.task43982groupuser;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        User user1 = new User("Максим", 12, "Пивнуха", "ул.Пушкина 1/2");
        User user2 = new User("Игорь", 13, "Стрипуха", "ул.Пушкина 1/6");
        User user3 = new User("Валера", 14, "Уник", "ул.Пушкина 1/5");
        User user4 = new User("Сергкй", 14, "Школа", "ул.Пушкина 1/4");
        User.users.add(user1);
        User.users.add(user2);
        User.users.add(user3);
        User.users.add(user4);

        Map<Integer, List<User>> resault = User.groupUsers(User.users);
        for (Map.Entry<Integer, List<User>> entry : resault.entrySet()) {
            System.out.println("Возраст:" + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.printf("Имя: %s, Адрес: %s, Место работы: %s%n",
                        user.getName(), user.getAddress(), user.getWorkplace());
            }
            System.out.println();
        }

    }
}

