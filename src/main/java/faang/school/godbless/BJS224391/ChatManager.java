package faang.school.godbless.BJS224391;

import java.util.List;

public class ChatManager {
    private List<User> users;
    public void startChat(User user) throws InterruptedException {
        synchronized (this){
            for (User searchUser : UserList.getOnlineUsers()){
                if(!searchUser.isChat()){
                    Chat chat = new Chat();
                    user.setChatId(chat.getId());
                    searchUser.setChatId(chat.getId());
                    break;
                }
            }
            waitForChat(user);
        }
    }

    public void waitForChat(User user) throws InterruptedException {
        synchronized (this){
            while (true){
                this.wait();
            }
            //
        }
    }

    public void endChat(){

    }
}
