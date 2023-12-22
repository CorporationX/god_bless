package Synchronization_7;

import java.util.Objects;

public class User {

    private boolean online;
    private String name;
    private boolean sex = false;
    private boolean readyToContact;


    public User(String name, String sex) {
        this.name = name;
        if (sex.equals("f"))
            this.sex = true;
        if (Math.random() * 50 > 10)
            online = true;
        else
            online = false;
    }

    public void setUpReadyToContact(boolean readyToContact) {
        this.readyToContact = readyToContact;
        if (readyToContact) {
            ChatManager.startChat(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return online == user.online && sex == user.sex && readyToContact == user.readyToContact && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(online, name, sex, readyToContact);
    }

    public boolean isOnline() {
        return online;
    }

    public String getName() {
        return name;
    }

    public boolean isSex() {
        return sex;
    }

    public boolean isReadyToContact() {
        return readyToContact;
    }
}
