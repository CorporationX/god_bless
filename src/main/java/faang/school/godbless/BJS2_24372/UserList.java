package faang.school.godbless.BJS2_24372;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UserList {

    private final List<User> users;

    public List<User> getUsersByStatus(Status status) {
        return users.stream()
                .filter(user -> user.getStatus() == status)
                .toList();
    }

    public synchronized User getUserWantsChattingExceptUser(User user) {
        return users.stream()
                .filter(partner -> !partner.equals(user) && isSuitable(user, partner))
                .findFirst().orElse(null);
    }

    private boolean isSuitable(User user, User partner) {
        boolean isWantsChatting = partner.getStatus() == Status.WANTS_CHATTING;
        boolean isPreferred = partner.getGender() == user.getPreference() && partner.getPreference() == user.getGender();
        return isPreferred && isWantsChatting;
    }
}
