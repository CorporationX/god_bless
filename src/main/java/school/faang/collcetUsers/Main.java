package school.faang.collcetUsers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> activities1 = new HashSet<>(Arrays.asList("Бег","Ходьба"));

        List<String> activitiesList1 = new ArrayList<>(activities1);
        User user1 = new User(1, "Alisa", 25, activitiesList1, "Google", "London");

        System.out.println(user1);
    }
}
