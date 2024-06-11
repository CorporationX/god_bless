package faang.school.godbless.collectibleUsers;

import java.util.*;

public class User {
    private int id;
    private String name;
    private Integer year;
    private Set<String> manyActivities;

    public User(int id, String name, Integer year, Set<String> manyActivities) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.manyActivities = manyActivities;
    }

    public String getName() {
        return name;
    }

    public Set<String> getManyActivities() {
        return manyActivities;
    }


    public static HashMap<User, String> findHobbyLovers(List<User> user, Set<String> manyActivities) {
        HashMap<User, String> findHobbyMap = new HashMap<>();

        if (manyActivities != null && !manyActivities.isEmpty()) {
            user.forEach(userFind -> {
                manyActivities.forEach(activities -> {
                    if (userFind.getManyActivities().contains(activities)) {
                        findHobbyMap.put(userFind, activities);
                    }
                });
            });
        }
        return findHobbyMap;
    }
}
