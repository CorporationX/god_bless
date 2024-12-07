package school.faang.sprint1.bjs_43985;

import com.github.javafaker.Faker;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static User generateUserData(int interestNumber) {
        Faker faker = new Faker();
        int id = faker.number().numberBetween(1, 1000);
        String name = faker.name().fullName();
        int age = faker.number().numberBetween(15, 100);
        String[] interests = new String[interestNumber];
        for (int i = 0; i < interestNumber; i++) {
            interests[i] = faker.ancient().hero();
        }
        return new User(id, name, age, Set.of(interests));
    }

    public static void main(String[] args) {
        List<User> users = List.of(
                generateUserData(3),
                generateUserData(2),
                generateUserData(4),
                generateUserData(2)
        );
        User generatedUser = generateUserData(10);
        Set<String> hobbies = generatedUser.getActivities();
        users.forEach(System.out::println);
        //System.out.println(hobbies);
        System.out.println("--------");

        Map<User, String> resultList = User.findHobbyLovers(users, hobbies);
        resultList.forEach((user, hobby) ->
                System.out.println(user + " -> " + hobby)
        );
    }
}
