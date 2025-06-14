package school.faang.bjs279226;

import java.util.List;
import school.faang.bjs279226.model.User;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello BJS2-79226!");

        var usersByAge = User.groupUsers(List.of(
            new User("John", 25, "Amazon", "Orbita district"),
            new User("Alex", 35, "Amazon", "Orbita district"),
            new User("Misha", 45, "Google", "Orbita district"),
            new User("Alena", 35, "Chevron", "Orbita district"),
            new User("Anna", 25, "SevenEleven", "Orbita district"),
            new User("William", 55, "Amazon", "Orbita district"),
            new User("Amirzhan", 26, "Microsoft", "Orbita district"),
            new User("Amir", 32, "Netflix", "Orbita district")
        ));
        System.out.println(usersByAge);
    }
}
