package school.faang.BJS2_68073;

import java.util.List;
import java.util.Map;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                User.builder().id(1).name("Антон").age(39).activities(Set.of("бег", "плавание")).build(),
                User.builder().id(2).name("Юля").age(24).activities(Set.of("бег", "настолки")).build(),
                User.builder().id(3).name("Олег").age(21).activities(Set.of("настолки", "чтение")).build(),
                User.builder().id(4).name("Дима").age(31).activities(Set.of("чтение", "рисование")).build(),
                User.builder().id(5).name("Саша").age(45).activities(Set.of("оригами", "программирование")).build()
        );

        Set<String> activities = Set.of("бег", "чтение");
        Map<User, String> hobbyLovers = User.findHobbyLovers(users, activities);
        System.out.println(hobbyLovers);

    }

}
