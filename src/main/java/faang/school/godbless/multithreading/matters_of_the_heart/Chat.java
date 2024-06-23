package faang.school.godbless.multithreading.matters_of_the_heart;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chat {

    public User fUser;

    public User sUser;

    public boolean isActive;

    public void communication() {
        System.out.println("бла-бла-бла");
    }
}
