package faang.school.godbless.BJS29796;

import faang.school.godbless.BJS29796.entity.Comment;
import faang.school.godbless.BJS29796.entity.User;
import faang.school.godbless.BJS29796.service.CommentService;

/**
 * У нас есть сущность пользователь. Пиши его так, как видишь. Пользователь можешь отправить комментарий, удалить его, отредактировать. Соотвестевнно, есть сущность комментарий. Есть какой-то контроллер, который это принимает, и сервис, который это обрабатывает. Напиши цепочку обработчиков в соответствии с паттерном, которые будут:
 * <p>
 * 1) Отлавливать матершину на двух языках - русский и английский (не углубляйся, по 5 -10 самых таких слов будет достаточно)
 * 2) Ловить сообщения, в которых есть ссылка (какой-то урл)
 * 3) Ловить сообщения, которые содержат расизм
 * 4) Ловить сообщения, в которых есть мейл
 * 5) Детектить атаку ботов (если люди пишут с разных аккаунтов одно и то же сообщение)
 * <p>
 * В случае вайолейта какого-то из этих пунктов - заблокируй сообщение, добавь пользователю предупреждение, и добавь логику для блокировки пользователя, которая будет основана на повторном нарушении правил использования сервиса.
 */

public class ApplicationRunner {

    private static final CommentService COMMENT_SERVICE = new CommentService();

    public static void main(String[] args) {
        User user1 = new User("Бот1");
        Comment comment1User1 = new Comment("спам", user1);
        Comment comment2User1 = new Comment("Перейди по ссылке плиз https://www.youtube.com/", user1);
        Comment comment3User1 = new Comment("Эй <Матерщина>!!", user1);
        User user2 = new User("Бот2");
        Comment comment1User2 = new Comment("спам", user2);

        addComment(comment1User1);
        addComment(comment2User1);
        addComment(comment3User1);
        addComment(comment1User2);

        System.out.println();
        System.out.println(String.join(" ", user1.getName(), user1.getState().name(), ":должен быть забанен"));
        System.out.println(String.join(" ", user2.getName(), user2.getState().name(), ":должен быть с предупреждением"));
    }

    private static void addComment(Comment comment) {
        try {
            COMMENT_SERVICE.addComment(comment);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
