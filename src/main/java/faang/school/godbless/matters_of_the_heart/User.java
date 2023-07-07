package faang.school.godbless.matters_of_the_heart;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class User {
    private String name;
    private boolean isOnline = true;
    private boolean prepareToChat = false;

    public User(String name) {
        this.name = name;
    }

    public void exit() {
        synchronized(this) {
            isOnline = false;
            prepareToChat = false;
            System.out.println(this.getName() + " exited the app");
            this.notifyAll();
        }

    }

    public void connect() {
        synchronized (this) {
            isOnline = true;
            this.notifyAll();
        }
    }

    public synchronized void searchChat() {
        synchronized (this) {
            if(!this.isOnline) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            prepareToChat = true;
            notifyAll();
        }
    }

    public synchronized void toDoNotDisturb() {
        synchronized (this) {
            prepareToChat = false;
            notifyAll();
        }
    }
}
