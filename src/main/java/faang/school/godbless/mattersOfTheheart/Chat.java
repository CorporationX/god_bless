package faang.school.godbless.mattersOfTheheart;

import lombok.Data;

@Data
public class Chat {
    private User userOne;
    private User userTwo;

    public void startChat(User user1, User user2) {
        userOne = user1;
        userTwo = user2;
        user2.setChatStatus(UserChatStatus.CHATTING);
        user1.setChatStatus(UserChatStatus.CHATTING);
        System.out.println("Started new chat between " + user1.getName() + " and " + user2.getName());
    }

    public void closeChat() {
        userOne.setChatStatus(UserChatStatus.AVAILABLE);
        userTwo.setChatStatus(UserChatStatus.AVAILABLE);
        System.out.println("Chat between " + userOne.getName() + " and " + userTwo.getName()+ " is ended.");
        userOne = null;
        userTwo = null;
    }
}
