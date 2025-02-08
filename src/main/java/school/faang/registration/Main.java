package school.faang.registration;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        String[][] userData = {
                {"Ira", "18", "Google", "Tokio"},
                {"Vadim", "17", "Gogle", "Amsterdam"},
                {"Valera", "19", "Uber", "Amsterdam"},
                {"Maksim", "18", "Jira", "Amsterdam"},
                {"Vasiliy", "18", "Amazon", "Tokio"}
        };

        for (String[] data : userData) {
            try {
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String company = data[2];
                String city = data[3];

                User user = new User(name, age, company, city);
                users.add(user); // Добавляем пользователя в список
            } catch (IllegalArgumentException ex) {
                System.out.println("Fault by user creating: " + ex.getMessage());
            }
        }
    }
}
