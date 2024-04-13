package faang.school.godbless.BJS2_5326;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private int id;
    private String name;
    private int age;
    private List<String> activity;

    public Map<String, String> findHobbyLovers(Map<String, List<String>> users, List<String> activity) {
        Map<String, String> result = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : users.entrySet()) {
            for (String hobby : entry.getValue()) {
                if (activity.contains(hobby)) {
                    result.put(entry.getKey(), hobby);
                    break;
                }
            }
        }
        return result;
    }
}
