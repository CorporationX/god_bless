package faang.school.godbless.collecting;

import java.util.List;
import java.util.Set;

import static faang.school.godbless.collecting.User.findHobbyLovers;

public class CollectingMain {

    public static void main(String[] args) {
        System.out.println(findHobbyLovers(
                List.of(
                        new User(1, "John", 18, Set.of("football", "basketball")),
                        new User(2, "Jane", 25, Set.of("drawing")),
                        new User(3, "Jame", 40, Set.of("welding", "fishing")),
                        new User(4, "Jax", 31, Set.of("fighting", "powerlifting", "running")),
                        new User(5, "John", 27, Set.of("volleyball", "hunting")),
                        new User(6, "Jack", 35, Set.of("baseball", "dancing"))
                ),
                Set.of(
                        "basketball", "welding", "running", "volleyball", "dancing"
                )
        ));
    }
}
