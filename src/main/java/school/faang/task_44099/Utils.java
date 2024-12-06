package school.faang.task_44099;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Utils {

    public static Set<String> getAllHobbies(List<User> users) {
        Set<String> uniqueHobbies = new HashSet<>();
        for (User user : users) {
            uniqueHobbies.addAll(Arrays.asList(user.getHobbies()));
        }
        return uniqueHobbies;
    }

    public static Set<String> getRandomHobbiesList(List<User> userList) {
        Set<String> hobbiesList = getAllHobbies(userList);
        Set<String> shortSetHobbiesList = new HashSet<>();
        ArrayList<String> shortHobbiesList = new ArrayList<>(hobbiesList.stream().toList());
        Random random = new Random();
        int randomSize = random.nextInt(6, userList.size());
        for (int i = 0; i < randomSize; i++) {
            shortSetHobbiesList.add(shortHobbiesList.get(i));
        }
        return shortSetHobbiesList;
    }

    public static String formatHobbyLoversPrettyView(Map<User, String> hobbyLovers) {
        StringBuilder sb = new StringBuilder("{\n");
        int i = 0;
        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            User user = entry.getKey();
            String hobby = entry.getValue();
            int userIdLength = String.valueOf(user.getId()).length();
            int paddingLength = 2 - userIdLength; //Desired padding: 2 total - ID Length
            sb.append("  ").append(user.getId());
            if (paddingLength > 0) {  //Only add padding if needed
                sb.append(" ".repeat(paddingLength));
            }
            sb.append(": [ User ")
                    .append(user.getName()).append(" loves ").append(hobby).append(" ]");
            if (++i < hobbyLovers.size()) {
                sb.append(",\n");
            } else {
                sb.append("\n");
            }
        }
        sb.append("}\n");
        return sb.toString();
    }
}
