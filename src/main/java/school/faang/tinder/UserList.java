package school.faang.tinder;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static school.faang.tinder.ChatManager.INCORRECT_LOOKING_FOR_CHAT_STATE_MESSAGE;

@AllArgsConstructor
public class UserList {
    private final List<User> users = new ArrayList<>();
    private final ChatManager chatManager;

    public List<User> getOnlineUsers() {
        return users.stream()
                .filter(User::isOnline)
                .toList();
    }

    public synchronized void addUser(User user) {
        users.add(user);
        System.out.println(user.getName() + " был добавлен в список");
        notifyAll();
    }

    public synchronized void removeUser(User user) {
        if (chatManager.isInAnyChat(user)) {
            Chat chat = chatManager.getChatByUser(user).orElseThrow(
                    () -> new IllegalStateException(INCORRECT_LOOKING_FOR_CHAT_STATE_MESSAGE +
                            user.getName()));
            chatManager.endChat(chat.getChatId());
        }
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
