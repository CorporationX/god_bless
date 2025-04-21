package school.faang.stream2.useractivityinsocialnet;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class UsersByID {
    private Map<Integer, User> users = new HashMap<>();;

    public void setUsers(List<User> userList) {
        userList.stream()
                .forEach(user ->
                        users.put(user.getId(), user));
    }
}
