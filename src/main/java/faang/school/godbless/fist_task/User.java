package faang.school.godbless.fist_task;


import java.util.*;

public record  User(String name, int age, String placeWork, String address) {

    public static HashMap groupUsers(List<User> users) {
        HashMap<Integer, List<User>> workers = new HashMap<>();
        for (int i = 0; i < users.size(); i++) {
                if (!workers.containsKey(users.get(i).age)) {
                    workers.put(users.get(i).age, new ArrayList<>());
                    workers.get(users.get(i).age).add(users.get(i));
                } else {
                    workers.get(users.get(i).age).add(users.get(i));
                }
            }
        return workers;
    }
}