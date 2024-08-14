package collect;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        Set<String> acts = Set.of("anzhumania", "pres ka4at", "begit");

        User andrey = new User();
        andrey.setId(1);
        andrey.setAge(33);
        andrey.setName("Andrey");
        andrey.setActivities(Set.of("Java", "snowboard", "anzhumania", "begit"));
        User elon = new User();
        elon.setId(1);
        elon.setAge(33);
        elon.setName("Elon");
        elon.setActivities(Set.of("smoke", "reading", "begit", "anzhumania"));
        User arnold = new User();
        arnold.setId(1);
        arnold.setAge(33);
        arnold.setName("Arnold");
        arnold.setActivities(Set.of("smoke", "reading", "bodybuilding"));

        List<User> users = new ArrayList<>();
        users.add(andrey);
        users.add(elon);
        users.add(arnold);

        Map<User, String> map = User.findHobbyLovers(users, acts);
    }
}
