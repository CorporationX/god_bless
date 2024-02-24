package faang.school.godbless.mattersoftheheart;

public class Chat {
    private User user1;
    private User user2;

    public Chat(User user1, User user2){
        user1.setWantsToChat(false);
        user2.setWantsToChat(false);
        this.user1 = user1;
        this.user2 = user2;
    }

    public User getUser1() {
        return user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public boolean isFull() {
        if (user1 != null & user2 != null){
            return true;
        }
        return false;
    }

    public void leaveChat(User user){
        if (user1 == user){
            user1 = null;
        }
        if (user2 == user){
            user2 = null;
        }
    }
}
