package derschrank.sprint03.task13.bjstwo_49141;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ChatManager implements ChatManagerInterface {
    private static final User FLAG_USER_IS_EGAGED_ALS_ACTIVE_USER = new User("user-plug for flag");
    private static final int TRY_TO_FIND_ANY_FREE_USER_BEFORE_WAIT = 10;
    private static final int TIMEOUT_FOR_AWAIT_NOTIFICATION_MILLIS = 1000;

    private final UserList users;
    private final List<Chat> chats;
    ReentrantLock lock;
    //ExecutorService

    public ChatManager(UserList users) {
        this.users = users;
        chats = new ArrayList<>();
        lock = new ReentrantLock();
    }

    @Override
    public void startChat(User forUser) {
        while (true) {
            if (engageUser(forUser, FLAG_USER_IS_EGAGED_ALS_ACTIVE_USER)
                && getAnyFreeUserAndTryStartNewChat(forUser)) {
                return;
            }
            waitForChat(forUser);
        }
    }

    private boolean getAnyFreeUserAndTryStartNewChat(User forUser) {
        Optional<User> optionalUser = getAnyFreeUserAndTryEngageHim(forUser);
        if (optionalUser.isPresent()) {
            User withUser = optionalUser.get();
            Optional<Chat> optionalChat;

            if ((optionalChat = tryMakeAchat(forUser, withUser)).isPresent()) {
                Chat chat = optionalChat.get();
                ChatManagerService.logChatIsMade(chat);
                chatting(chat);

                synchronized (this) {
                    chats.add(chat);
                }
                return true;
            } else {
                ChatManagerService.logChatIsNotMade(forUser, withUser);
            }
        }
        return false;
    }

    private Optional<User> getAnyFreeUserAndTryEngageHim(User forUser) {
        Optional<User> optional;
        int count = 0;
        do {
            optional = findAnyFreeUser(forUser);
            if (optional.isEmpty()) {
                break;
            }
            if (engageUser(optional.get(), forUser)) {
                return optional;
            }
            count++;
        } while (count < TRY_TO_FIND_ANY_FREE_USER_BEFORE_WAIT);
        return Optional.empty();
    }

    private Optional<User> findAnyFreeUser(User forUser) {
        return users.getOnlineUsersAwaitForNewChat().stream()
                .filter(u -> u != forUser)
                .findAny();
    }

    private boolean engageUser(User user, User forUser) {
        return user.engage(forUser);
    }

    private void unengageUser(User user, User forUser) {
        user.leaveFromEngage(forUser);
    }

    private Optional<Chat> tryMakeAchat(User activeUser, User passiveUser) {
        Chat chat = new Chat(activeUser, passiveUser);
        if (passiveUser.joinToChat(chat, activeUser)) {
            activeUser.changeEngage(FLAG_USER_IS_EGAGED_ALS_ACTIVE_USER, passiveUser);
            activeUser.joinToChat(chat, passiveUser);
            return Optional.of(chat);
        }
        return Optional.empty();
    }

    private void chatting(Chat chat) {
        Thread threadToChat = new Thread(() -> {
            chat.chating();
            endChat(chat);
        });
        threadToChat.start();
    }

    @Override
    public void waitForChat(User forUser) {
        ChatManagerService.logUserAwait(forUser);
        unengageUser(forUser, FLAG_USER_IS_EGAGED_ALS_ACTIVE_USER);
        forUser.setActiveLookingForChat(false);
        try {
            synchronized (this) {
                wait(TIMEOUT_FOR_AWAIT_NOTIFICATION_MILLIS);
            }
        } catch (InterruptedException e) {
            ChatManagerService.logUserAwaitWasInterrupted(forUser, e);
        }
    }

    @Override
    public void endChat(Chat chat) {
        ChatManagerService.logChatIsEnded(chat);
        chat.end();
        synchronized (this) {
            chats.remove(chat);
            this.notifyAll();
        }
    }

    public boolean isNotActiveChats() {
        return chats.isEmpty();
    }
}
