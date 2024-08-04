package faang.school.godbless.BJS2_18399;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<String> hobbies = Set.of("Sailing", "Music", "Fishing", "Dancing", "Reading");

        List<User> users = new ArrayList<>(3);
        users.add(new User(1, "Adam", 21, new HashSet<String>(Set.of("Riidng", "Reading", "Music")) ) );
        users.add(new User(2, "Mark", 32, new HashSet<String>(Set.of("Dancing", "Sailing", "Fishing")) ) );
        users.add(new User(3, "Albert", 68, new HashSet<String>(Set.of("Physics", "Appling", "Reading")) ) );

        Map<User, String> hobbyLovers = User.findHobbyLovers(users,hobbies);

        for (HashMap.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println(entry.getKey().getName() + ": " + entry.getValue());
        }

    }
}
