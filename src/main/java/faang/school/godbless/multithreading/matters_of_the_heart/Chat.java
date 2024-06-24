package faang.school.godbless.multithreading.matters_of_the_heart;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chat {

    public final User fUser;

    public User sUser;

    public boolean isActive;

    public void communication(ChatManager chatManager) throws InterruptedException {
        System.out.println(fUser.getName() + " and " + sUser.getName() + " chating...");
        Thread.sleep(5000);
        System.out.println("Ending chating " + fUser.getName() + " and " + sUser.getName());
        this.isActive=false;
        chatManager.endChat(this);
    }
}
