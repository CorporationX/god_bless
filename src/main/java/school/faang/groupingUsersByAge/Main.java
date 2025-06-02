package school.faang.groupingUsersByAge;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> city = new ArrayList<>() {{
            add("Moskov");
            add("Omsk");
            add("Tula");
            add("Yral");
        }};
        ArrayList<String> name = new ArrayList<>() {{
            add("Vlad");
            add("Sasha");
            add("Dima");
            add("Igor");
        }};
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int ageRandom = (int) (Math.random() * (30 - 20 + 1)) + 20;
            int nameRandom = new Random().nextInt(3);
            int cityRandom = new Random().nextInt(3);
            int cityWorkRandom = new Random().nextInt(3);

            userList.add(new User(name.get(nameRandom),
                    ageRandom, city.get(cityRandom),
                    city.get(cityWorkRandom)));
        }
        System.out.println(User.groupUsers(userList).get(22));
    }
}
