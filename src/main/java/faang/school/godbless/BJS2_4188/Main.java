package faang.school.godbless.BJS2_4188;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>(
                List.of(
                        new User(1L, "Tom", 25, List.of("Online Games", "Swim", "Watch TV")),
                        new User(2L, "Rob", 25, List.of("Tennis", "Football", "Painting")),
                        new User(3L, "Kate", 26, List.of("Learn an Instrument", "Music", "Yoga"))
                ));

        Map<User, String> result = User.findHobbyLovers(users, List.of("Music", "Yoga"));

        for (Map.Entry<User, String> entry : result.entrySet()) {
            System.out.println(entry.getKey().getName() + entry.getValue());
        }

    }
}
