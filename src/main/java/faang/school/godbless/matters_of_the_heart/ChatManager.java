package faang.school.godbless.matters_of_the_heart;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChatManager {

    public ChatManager(UserList userList) {
        userList.getOnlineUsers().stream().forEach((user -> {
            if(user.getGender().equals("female")){
                usersWantToChatFemale.add(user);
            }else{
                usersWantToChatMale.add(user);
            }
        }));
    }

    private final List<User> usersWantToChatMale = new ArrayList<>();
    private final List<User> usersWantToChatFemale = new ArrayList<>();
    private final List<Chat> chats = new ArrayList<>();

    public synchronized void startChat(User user) {
        List<User> needChat = getNeedChat(user);
        if (needChat.isEmpty()) {
            System.out.println("No one who wants to chat");
            getNeedChat(user.getGender()).add(user);
            waitForChat(user);
        } else {
            Chat chat = new Chat();
            chat.addUserToChat(user);
            chat.addUserToChat(needChat.get(0));
            needChat.remove(0);
            chats.add(chat);
            notify();
            System.out.println("joined the chat " + user.getName());
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
        if(chatForRemove.isPresent()){
            chats.remove(chatForRemove.get());
            User userWantToChat = chatForRemove.get().getUsersInChat().stream().filter(user1 -> !user1.equals(user)).findFirst().get();
            startChat(userWantToChat);
        }
    }

    private List<User> getNeedChat(User user) {
        return user.getGender().equals("female") ? usersWantToChatMale : usersWantToChatFemale;
    }

    private List<User> getNeedChat(String gender) {
        return gender.equals("female") ? usersWantToChatFemale : usersWantToChatMale;
    }
}
