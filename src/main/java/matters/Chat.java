package matters;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Data
@AllArgsConstructor
public class Chat  {
    private List<User> users = new ArrayList<>();

    public Chat(User user1, User user2) {
        users.addAll(Arrays.asList(user1,user2));
    }


}
