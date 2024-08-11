package faang.school.godbless.BJS2_19885;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Query {
    private int id;
    private String content;
    private LocalDateTime timestamp;

    public static void addQueryForUser(User user, Query query) {
        if (!Main.queriesByUser.containsKey(user)) {
            Main.queriesByUser.put(user, new ArrayList<>());
        }
        Main.queriesByUser.get(user).add(query);
    }
}

