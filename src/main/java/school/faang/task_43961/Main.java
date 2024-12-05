package school.faang.task_43961;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] testNames = {"Alisa", "Chebarkul", "Cheburek", "Alabama", "Matroskin", "Cow"};
        String[] testHobbies = {"Coding", "Games", "Sport", "Hardwork", "Nothing", "Chilling", "Idk", "Shopping"};
        List<User> users = new ArrayList<User>();
        Random rand = new Random();
        for (int i = 0; i <= 100; i++) {
            int id = i;
            String name = testNames[rand.nextInt(testNames.length)];
            int age = rand.nextInt(18, 100);
            Set<String> hobbies = new HashSet<String>();
            for (int n = 0; n <= 3; n++) {
                hobbies.add(testHobbies[rand.nextInt(testHobbies.length)]);
            }
            users.add(new User(id, name, age, hobbies));
        }

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, Set.of(testHobbies));
        System.out.println(hobbyLovers);
    }

}
