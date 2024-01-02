package faang.school.godbless.BJS2_1286;

import lombok.Data;

import java.util.*;
import java.util.stream.Stream;

@Data
public class ChatManager {
    private final UserList userList;
    private final Set<User> acceptedToChattingUsers = new HashSet<>();
    private final Set<UserPair> chattingUserPairs = new HashSet<>();
    private final List<Chat> chats = new ArrayList<>();

    public ChatManager(UserList userList) {
        this.userList = userList;
    }

    public synchronized Chat startChat(User user) {
        acceptedToChattingUsers.add(user);

        while (!isUserChatting(user)) {
            List<User> usersToChatWith = readyToStartChatWith(user);
            if (!usersToChatWith.isEmpty() && user.isOnline()) {
                this.notify();
                startChatWithUser(user, usersToChatWith.get(0));
                break;
            }

            try {
                System.out.println(Thread.currentThread() + "waiting list: " + acceptedToChattingUsers + "||| " + user + " is waiting...");
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Chat was created for " + user);
        return findChatByUser(user);
    }

    public void waitForChat(User user) {
    }

    public synchronized void endChat(User user) {
        User chattingSecondUser = findChattingSecondUser(user);
        chattingUserPairs.remove(new UserPair(user, chattingSecondUser));
        acceptedToChattingUsers.remove(user);
        acceptedToChattingUsers.remove(chattingSecondUser);

        System.out.println(Thread.currentThread() + "chat ended between: " + user + " and " + chattingSecondUser
                + "That means you can start chat with both of these users!");
        this.notifyAll();
    }

    public List<Chat> getAllChats () {
        return chats;
    }

    private Chat startChatWithUser(User user, User userToChatWith) {
        chattingUserPairs.add(new UserPair(user, userToChatWith));

        Chat chat = new Chat(user, userToChatWith);
        chats.add(chat);
        System.out.println(Thread.currentThread() + "chat " + chat + " started between: " + user + " and " + userToChatWith);
        return chat;
    }


    private List<User> readyToStartChatWith(User user) {
        return acceptedToChattingUsers.stream()
                .distinct()
                .filter(u -> userList.followsToEachOther(user, u)  && !isUserChatting(user))
                .filter(u -> u.isOnline())
                .toList();
    }

    private Chat findChatByUser(User user) {
        return chats.stream().filter(chat -> chat.getUser1().equals(user) || chat.getUser2().equals(user))
                .findFirst().orElse(null);
    }

    private boolean isUserChatting(User user) {
        return chattingUserPairs.stream().anyMatch(symmetricUserPair -> symmetricUserPair.containsAny(user));
    }

    private User findChattingSecondUser(User user) {
        for (var pair : chattingUserPairs) {
            if (pair.containsAny(user)) {
                return pair.getAnotherByUser(user);
            }
        }
        return null;
    }
}
