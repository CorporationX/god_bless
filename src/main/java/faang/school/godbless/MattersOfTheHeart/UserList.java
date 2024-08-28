package faang.school.godbless.MattersOfTheHeart;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public class UserList {
    private final Map<User,Boolean> usersWithHisOnlineOrOfflineStatus = new HashMap<>();

    public Set<User> getOnlineUsers(){
        return usersWithHisOnlineOrOfflineStatus.entrySet().stream()
                .filter(Map.Entry::getValue)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public void changeStatusActivityToOnline(User user){
        usersWithHisOnlineOrOfflineStatus.put(user,true);
    }

    public void changeStatusActivityToOffline(User user){
        usersWithHisOnlineOrOfflineStatus.put(user,false);
    }
}
