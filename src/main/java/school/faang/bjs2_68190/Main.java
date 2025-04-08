package school.faang.bjs2_68190;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
            new User("William Clark", 30, "EcoEnergy", "2627 Poplar Circle, Pawnee, IN 47998"),
            new User("Isabella Lewis", 30, "MedLife", "2829 Willow Lane, Twin Peaks, WA 98065"),
            new User("James Walker", 39, "SecureNet", "3031 Magnolia Street, Derry, ME 04401"),
            new User("Mia Young", 27, "DesignLab", "3233 Palm Road, Sunnydale, CA 94086"),
            new User("Benjamin Hall", 39, "LogiTech", "3435 Pinecrest Blvd, Fairview, CO 80305")
        );

        Map<Integer, List<User>> groupedByAgeUsers = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : groupedByAgeUsers.entrySet()) {
            System.out.println(entry);
        }
    }
}
