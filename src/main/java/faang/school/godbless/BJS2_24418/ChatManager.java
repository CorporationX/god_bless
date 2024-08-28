package faang.school.godbless.BJS2_24418;

public class ChatManager {
    private UserList users;

    public ChatManager(UserList users) {
        this.users = users;
    }

    public synchronized void startChat(User user) {
        while (users.getOnlineUsers().isEmpty() || users.getOnlineUsers().stream().filter(User::isWantToChat).toList().isEmpty()) {
            System.out.println(user.getName() + " can't talk anybody");
            waitForChat(2000);
        }
        User secondUser = users.getOnlineUsers().stream()
                .filter(us -> !us.isChatting() && us.isWantToChat())
                .findFirst().get();
        Chat chat = new Chat(user, secondUser);
        user.setChat(chat);
        secondUser.setChat(chat);
        secondUser.setChatting(true);
        secondUser.setWantToChat(false);
        chat.startTalk();
    }

    public void waitForChat(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void endChat(User user) {
        Chat chat = user.getChat();
        System.out.println("Chat between " + user.getName() + " and " + chat.getUser2().getName() + " ended");
        chat.getUser1().setChat(null);
        chat.getUser2().setChat(null);
        chat.getUser1().setChatting(false);
        chat.getUser2().setChatting(false);
        chat.getUser2().setWantToChat(true);
        notifyAll();
    }
}
