package faang.school.godbless.matters_of_the_heart;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class ChatManager {

    private final List<User> usersWantToChatMale = new ArrayList<>();
    private final List<User> usersWantToChatFemale = new ArrayList<>();
    private final List<Chat> chats = new ArrayList<>();

    private List<User> getNeedChat(User user) {
        return user.getGender().equals("female") ? usersWantToChatMale : usersWantToChatFemale;
    }

    private List<User> getNeedChat(String gender) {
        return gender.equals("female") ? usersWantToChatFemale : usersWantToChatMale;
    }

    public ChatManager(UserList userList) {
        userList.getOnlineUsers().forEach((user -> {
            if (user.getGender().equals("female")) {
                usersWantToChatFemale.add(user);
            } else {
                usersWantToChatMale.add(user);
            }
        }));
    }

    public synchronized void startChat(User user) {
        List<User> needChat = getNeedChat(user);
        if (needChat.isEmpty()) {
            System.out.println("No one who wants to chat with " + user.getName());
            getNeedChat(user.getGender()).add(user);
            waitForChat(user);
        } else if (chats.stream().map(Chat::getUsersInChat).flatMap(Collection::stream).noneMatch(person -> person.equals(user))) {
            Chat chat = new Chat();
            chat.addUserToChat(user);
            chat.addUserToChat(needChat.get(0));
            System.out.println("joined the chat " + user.getName() + " and " + needChat.get(0).getName());
            needChat.remove(0);
            chats.add(chat);
        }
    }

    public synchronized void waitForChat(User user) {
        if (chats.stream().flatMap((chat) -> chat.getUsersInChat().stream()).noneMatch(person -> person.equals(user))) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void endChat(User user) {
        Optional<Chat> chatForRemove = chats.stream().filter(chat -> chat.isParticipating(user)).findFirst();
        if (chatForRemove.isPresent()) {
            User userWantToChat = chatForRemove.get().getUsersInChat().stream().filter(user1 -> !user1.equals(user)).findFirst().get();
            chats.remove(chatForRemove.get());
            getNeedChat(user.getGender()).remove(user);
            System.out.println("User " + user.getName() + " left and stayed: " + userWantToChat.getName());
            getNeedChat(userWantToChat.getGender()).add(userWantToChat);
            notify();
        }
    }
}
