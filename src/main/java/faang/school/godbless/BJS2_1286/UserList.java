package faang.school.godbless.BJS2_1286;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@NoArgsConstructor
@Data
public class UserList {
    private List<User> users = new ArrayList<>();
    private Map<User, Set<User>> followersByUser = new HashMap<>();
    private Set<UserPair> mutualFollowUserPairs = new HashSet<>();

    public List<User> getOnlineUsers() {
        return users.stream().filter(User::isOnline).toList();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void follow(User mainUser, User followUser) {
        followersByUser.computeIfAbsent(mainUser, v -> new HashSet<>()).add(followUser);

        if (followersByUser.getOrDefault(followUser, Collections.emptySet()).contains(mainUser)) {
            mutualFollowUserPairs.add(new UserPair(mainUser, followUser));
        }
    }

    public void unfollow(User mainUser, User unfollowUser) {
        followersByUser.get(mainUser).remove(unfollowUser);
        mutualFollowUserPairs.remove(new UserPair(mainUser, unfollowUser));
    }

    public Set<User> getFollowersByUser(User user) {
        return followersByUser.get(user);
    }

    public boolean followsToEachOther(User user1, User user2) {
        return mutualFollowUserPairs.contains(new UserPair(user1, user2));
    }
}