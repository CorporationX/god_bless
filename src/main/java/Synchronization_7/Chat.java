package Synchronization_7;

import java.util.Objects;

public class Chat {

    private User userMale;
    private User userFemale;

    public Chat(User user1, User user2) {
        if ((user1.isSex() == false) && (user2.isSex() == true)) {
            this.userMale = user1;
            this.userFemale = user2;
        } else if ((user1.isSex() == true) && (user2.isSex() == false)) {
            this.userMale = user2;
            this.userFemale = user1;
        }
        ChatManager.addChat(this);
    }

    public void personalContact() { //Demo only
        System.out.println(userFemale.getName() + " flirting with " + userMale.getName());
        System.out.println(userMale.getName() + " send yourself dickpick from " + userFemale.getName());
        try {
            Thread.sleep((int) (Math.random() * 1000));
        } catch (InterruptedException e) {
            System.out.println("This is too much...");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return Objects.equals(userMale, chat.userMale) && Objects.equals(userFemale, chat.userFemale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userMale, userFemale);
    }

    public User getUserMale() {
        return userMale;
    }

    public User getUserFemale() {
        return userFemale;
    }
}
