package faang.school.godbless.kxnvg.tinder;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Chat {

    private User firstUser;
    private User secondUser;

    public void startOfChating() {
        System.out.println("Начался чат между пользователями: " + firstUser.getName() + " и " + secondUser.getName());
        firstUser.setActualChat(this);
        secondUser.setActualChat(this);
    }

    public void finishChating() {
        System.out.println("Чат между пользователями: " + firstUser.getName() + " и " + secondUser.getName() + " завершен");
        firstUser.setActualChat(null);
        secondUser.setActualChat(null);
        firstUser = null;
        secondUser = null;
    }
}
