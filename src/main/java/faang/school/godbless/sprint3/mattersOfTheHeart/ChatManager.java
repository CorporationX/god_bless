package faang.school.godbless.sprint3.mattersOfTheHeart;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class ChatManager {

    private final Object lock = new Object();
    private final UserList userList;
    private final List<Chat> chatList;

    public ChatManager(UserList userList, List<Chat> chatList) {
        this.userList = userList;
        this.chatList = chatList;
    }

    public void startChat(User user) {
        try {
            System.out.println("start chat: " + user.getName());
            synchronized (userList.getLock()) {
                System.out.println("start chat sync: " + user.getName());
                if (!user.getHaveActiveChat()) {
                    List<User> availableUsersForChatting = userList.getUsers().stream()
                            .filter(u -> u.getOnline().equals(true) && u.getHaveActiveChat().equals(false) && !u.getId().equals(user.getId()))
                            .collect(Collectors.toList());
                    System.out.println("available users for chatting: " + availableUsersForChatting);
                    while (availableUsersForChatting.isEmpty()) {
                        //userList.getLock().wait();
                        waitForChat(user);
                    }

                    synchronized (lock) {
                        Optional<User> firstRandomUser = availableUsersForChatting.stream().findFirst();

                        firstRandomUser.ifPresent((u) -> {
                            //chatList.add(new Chat(u, user));
                            System.out.println("random user for chatting: " + u.getName());
                            chatList.add(new Chat(Arrays.asList(u, user)));
                            user.setHaveActiveChat(true);
                            u.setHaveActiveChat(true);
                        });
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitForChat(User user) {
        try {
            if (!user.getHaveActiveChat()) {
                System.out.println("wait: " + user.getName());
                synchronized (lock) {
                    lock.wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void endChat() {
        synchronized (lock) {
            Chat chat = chatList.get(new Random().nextInt(chatList.size() - 1));
            synchronized (userList.getLock()) {
                System.out.println("all active chats: " + chatList);
                System.out.println("updatind users before remove chat: " + chat);
                chat.updateUsersBeforeDeletingChat();
            }

            System.out.println("removing chat: " + chat);
            chatList.remove(chat);
            lock.notifyAll();
            System.out.println("all active chats after removing: " + chatList);
        }
    }
}
