package faang.school.godbless.mattersOfTheHeart;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
public class ChatManager {
    private List<Chat> chatList = new ArrayList<>();//список чатов


    //при вызове данного метода, юзер либо сразу создает чат с нужным юзером, либо вызывается метод
    //waitForChat, и юзер ждет, пока какой то другой юзер не вызовет метод startChat, как только
    //другой юзер вызывает этот метод, все ветки, в которых юзеры ждут новых собеседников, оповещаются, и
    //первый успевший забирает себе собеседника (вернее, тот юзер, который в параметре метода startChat,
    //выбирает себе в собеседники случайного степашку, а степашка уже проверяет,
    //не создал ли с ним чат какой нибудь слон, потому что каждого степашку оповестили, что создали новый чат)
    public synchronized Chat startChat(User user) {
        User user1;
        if ((user1 = findWantedToChatUser(user)) != null) {//есть ли пользователь, который хочет общаться
            user1.setWantChat(false);
            user.setWantChat(false);//чтобы пользователь случайно не оказался в двух чатах
            Chat chat = new Chat(user, user1);
            chatList.add(chat);
            notifyAll();
            return chat;
        } else {
            return waitForChat(user);
        }
    }

    private synchronized Chat waitForChat(User user) {
        user.setWantChat(true);
        try {
            while (true) {
                for (Chat chat : chatList) {
                    if (chat.containsUser(user)) {
                        return chat;
                    }
                }
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private User findWantedToChatUser(User user) {
        for (User user1 : UserList.getOnlineUsers()) {
            if (user1.isWantChat() && !user1.equals(user)) {
                return user1;
            }
        }
        return null;
    }


    //при вызове метода у пользователей удаляемого чата автоматически начинается поиск следующего собеседника
    public synchronized void endChat(Chat chat) {
        notifyAll();
        chatList.remove(chat);

        startChat((User) chat.getUsers().toArray()[0]);
        startChat((User) chat.getUsers().toArray()[1]);

        chat.deleteChat();
    }
}
