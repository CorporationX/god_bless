package school.faang.Group_Users_By_Age;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> johns = new ArrayList<>();
        johns.add(User.builder().name("John1").age(20).build());
        johns.add(User.builder().name("John2").age(21).build());
        johns.add(User.builder().name("John3").age(22).build());
        johns.add(User.builder().name("John4").age(24).build());
        johns.add(User.builder().name("John5").age(27).build());
        johns.add(User.builder().name("John6").age(23).build());
        johns.add(User.builder().name("John7").age(27).build());
        johns.add(User.builder().name("John8").age(22).build());
        johns.add(User.builder().name("John9").age(21).build());
        johns.add(User.builder().name("John10").age(20).build());

        System.out.println(User.groupUsers(johns));

    }
}
