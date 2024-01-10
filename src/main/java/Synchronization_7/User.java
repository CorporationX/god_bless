package Synchronization_7;

import java.util.Objects;

public class User {

    private boolean online;
    private String name;
    private Sex sex;
    private boolean readyToContact;
    private boolean isChatting;


    public User(String name, Sex sex) {
        this.name = name;
        this.sex = sex;
        if (Math.random() * 50 > 10)
            online = true;
        else
            online = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && sex == user.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sex);
    }

    public void setUpReadyToContact(boolean readyToContact) {
        this.readyToContact = readyToContact;
    }

    public void setChatting(boolean chatting) {
        isChatting = chatting;
    }

    public boolean isOnline() {
        return online;
    }

    public String getName() {
        return name;
    }

    public Sex isSex() {
        return sex;
    }

    public boolean isReadyToContact() {
        return readyToContact;
    }

    public boolean isChatting() {
        return isChatting;
    }
}
