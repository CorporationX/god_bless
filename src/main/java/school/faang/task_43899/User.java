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
    static Map<Integer, List<User>> dataUser = new HashMap<>();

    public User(String name, int age, String workplace, String address) {
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static void groupUsers(List<User> users) {
        for (User user : users) {
            if (dataUser.containsKey(user.age)) {
                dataUser.get(user.age).add(user);
            } else {
                List<User> newList = new ArrayList<>();
                newList.add(user);
                dataUser.put(user.age, newList);
            }
        }

    }

    public static void printUsers(Integer age) {
        if (dataUser.containsKey(age)) {
            for (User user : dataUser.get(age)) {
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