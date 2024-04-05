package faang.school.godbless.BJS2_4338;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args){
        List<User> users = new ArrayList<>();

        users.add(new User("Anton", 20, "Google", "London"));
        users.add(new User("Andrey", 19, "Uber", "New York"));
        users.add(new User("Ekaterina", 20, "Amazon", "Amsterdam"));
    }
}