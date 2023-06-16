package faang.school.godbless;


import java.util.*;

public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> hobbies;

    public Set<String> getHobbies() {
        return hobbies;
    }

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> hobbyLoversMap = new HashMap<>();
        for (User user : users) {
            Set<String> userHobbies = new HashSet<>(user.getHobbies());
            if (!userHobbies.isEmpty()) {
                for (String hobby : userHobbies) {
                    if (activities.contains(hobby)) {
                        hobbyLoversMap.put(user, hobby);
                        break;
                    }
                }
            }
        }
        return hobbyLoversMap;
    }

}





