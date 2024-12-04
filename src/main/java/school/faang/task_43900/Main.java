package school.faang.task_43900;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] testNames = {"Alisa", "Chebarkul", "Cheburek", "Alabama", "Matroskin", "Cow"};
        String[] testJobs = {"Amazon", "Google", "Uber", "Farm", "SpaceX", "Rostics"};
        String[] testAddress = {"Amsterdam", "Chebarkul", "Cherepovets", "Anapa", "Moscow", "Moon"};

        Random rand = new Random();
        List<User> users = new ArrayList<User>();
        for (int i = 0; i <= 1000; i++) {
            String name = testNames[rand.nextInt(testNames.length)];
            String job = testJobs[rand.nextInt(testJobs.length)];
            String address = testAddress[rand.nextInt(testAddress.length)];
            int age = rand.nextInt(18, 100);
            users.add(new User(name, age, job, address));
        }

        Map<Integer, List<User>> groupUsersByAge = User.groupUsers(users);

        System.out.println(groupUsersByAge);
    }
}
