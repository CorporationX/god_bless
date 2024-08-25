package faang.school.godbless.sprint3.mattersOfTheHeart;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Chat {
    private User firstUser;
    private User secondUser;

    public void start() {
        firstUser.setOnline(false);
        secondUser.setOnline(false);
        System.out.printf("Пользователи %s и %s начали общение%n", firstUser.getName(), secondUser.getName());
    }

    public void end() {
        firstUser.setOnline(true);
        secondUser.setOnline(true);
        System.out.printf("Пользователи %s и %s завершили чат%n", firstUser.getName(), secondUser.getName());
    }
}
