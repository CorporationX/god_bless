package faang.school.godbless.BJS2_18399;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashSet<String> hobbies = new HashSet<>(Arrays.asList("Sailing", "Music", "Fishing", "Dancing", "Reading"));

        ArrayList<User> users = new ArrayList<>(3);
        users.add(new User(1, "Adam", 21, new HashSet<String>(Arrays.asList("Riidng", "Reading", "Music")) ) );
        users.add(new User(2, "Mark", 32, new HashSet<String>(Arrays.asList("Dancing", "Sailing", "Fishing")) ) );
        users.add(new User(3, "Albert", 68, new HashSet<String>(Arrays.asList("Physics", "Appling", "Reading")) ) );

        HashMap<User, String> hobbyLovers = User.findHobbyLovers(users,hobbies);

        for (HashMap.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println(entry.getKey().getName() + ": " + entry.getValue());
        }

    }
}
