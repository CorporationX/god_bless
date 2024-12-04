package school.faang.task_43899;

import lombok.Getter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Getter
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;


    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static HashMap groupUsers(List<User> users) {
        Map<Integer, List<User>> dataUser = new HashMap<>();
        for (User user : users) {
            if (!dataUser.containsKey(user.age)) {
                dataUser.put(user.age, new ArrayList<User>());
            }
            dataUser.get(user.age).add(user);
        }
        return (HashMap) dataUser;
    }

    public static void printUsers(Integer age, Map<Integer, List<User>> userMap) {
        if (userMap.containsKey(age)) {
            for (User user : userMap.get(age)) {
                System.out.println("Name: " + user.name);
                System.out.println("Age: " + user.age);
                System.out.println("Workplace: " + user.workplace);
                System.out.println("Address: " + user.address);
                System.out.println("");
            }
        } else {
            System.out.println("Данная возрастная группа отсутсвует в базе данных!");
        }
    }

    public static Integer enterAge() throws IOException {
        Scanner scanner = new Scanner(System.in);
        try {
            Integer age = scanner.nextInt();
            return age;
        } catch (Exception e) {
            System.out.println("Необходимо ввести цифровое значение!");
            return 0;
        }
    }
}