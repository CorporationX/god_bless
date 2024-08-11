package faang.school.godbless.BJS2_19885;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Query {
    private int id;
    private String content;
    private LocalDateTime timestamp;

    public static void addQueryForUser(User user, Query query) {
        User.userQueryMap.get(user).add(query);
    }
}

