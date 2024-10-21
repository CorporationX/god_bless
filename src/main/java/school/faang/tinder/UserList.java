package school.faang.tinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class UserList {
    private final List<User> users = new ArrayList<>();

    public List<User> getOnlineUsers() {
        return users.stream()
                .filter(User::isOnline)
                .toList();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public int getSize() {
        return users.size();
    }

    public List<User> getUsers() {
        return new ArrayList<>(users);
    }

    public Optional<User> getInterlocutorFor(User user) {
        List<User> interlocutorCandidates = users.stream()
                .filter(user::isInterlocutorCandidate)
                .toList();
        Random random = new Random();
        return interlocutorCandidates.isEmpty()
                ? Optional.empty()
                : Optional.of(interlocutorCandidates.get(random.nextInt(interlocutorCandidates.size())));
    }

}
