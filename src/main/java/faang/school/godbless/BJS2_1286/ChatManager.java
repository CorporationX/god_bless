package faang.school.godbless.BJS2_1286;

import lombok.Data;

import java.util.*;

@Data
public class ChatManager {
    private final UserList userList;
    private final Set<User> waitingUsers = new HashSet<>();
    private final Set<UserPair> chattingUserPairs = new HashSet<>();
    private final List<Chat> chats = new ArrayList<>();

    public ChatManager(UserList userList) {
        this.userList = userList;
    }


    public synchronized Chat StartChat(User user) throws InterruptedException {
        waitingUsers.add(user);

        Optional<User> userWantsToChatWithOpt;
        while ((userWantsToChatWithOpt = readyToStartChatWith(user)).isEmpty() && !user.isOnline()) {
            if (isUserChatting(user)) {
                System.out.println(user + " is chatting");
                return findChatByUser(user);
            }
            this.wait();
        }

        User readyToChatUser = userWantsToChatWithOpt.get();
        System.out.printf("User %s created chat with user %s", user, readyToChatUser);
        return new Chat(user, readyToChatUser);
    }

    public void waitForChat(Chat chat) throws InterruptedException {
        while (!chats.contains(chat)) {
            this.wait();
        }
        startChat(chat);
    }

    private void startChat(Chat chat) {
        chat.setActive(true);
        chats.add(chat);

        User user1 = chat.getUser1();
        User user2 = chat.getUser2();

        chattingUserPairs.add(new UserPair(user1, user2));
        waitingUsers.remove(user1);
        waitingUsers.remove(user2);
    }

    public synchronized void endChat(Chat chat) {

    }

    public List<Chat> getAllChats() {
        return chats;
    }

    private Chat startChatWithUser(User user, User userToChatWith) {
        chattingUserPairs.add(new UserPair(user, userToChatWith));

        Chat chat = new Chat(user, userToChatWith);
        chats.add(chat);
        System.out.println(Thread.currentThread() + "chat " + chat + " started between: " + user + " and " + userToChatWith);
        return chat;
    }


    private Optional<User> readyToStartChatWith(User user) {
        if (isUserChatting(user)) {
            return Optional.empty();
        }
        return waitingUsers.stream()
                .distinct()
                .filter(u -> userList.followsToEachOther(user, u) && !isUserChatting(user))
                .filter(User::isOnline)
                .findFirst();
    }

    private Chat findChatByUser(User user) {
        return chats.stream().filter(chat -> chat.getUser1().equals(user) || chat.getUser2().equals(user))
                .findFirst().orElse(null);
    }

    private boolean isUserChatting(User user) {
        return chattingUserPairs.stream().anyMatch(userPair -> userPair.contains(user));
    }

    private User findChattingSecondUser(User user) {
        for (var pair : chattingUserPairs) {
            if (pair.contains(user)) {
                return pair.getAnotherByUser(user);
            }
        }
        return null;
    }
}