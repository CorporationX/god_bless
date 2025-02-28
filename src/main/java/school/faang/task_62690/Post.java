package school.faang.task_62690;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

@Getter
@AllArgsConstructor
public class Post {
    private int id;
    private String title;
    private String content;
    private String author;
    private List<Comment> comments;






    // Создайте класс Post, который представляет пост с полями:
    //
    //id — уникальный идентификатор поста,
    //
    //title — заголовок поста,
    //
    //content — текст поста,
    //
    //author — автор поста,
    //
    //comments — список комментариев (List<Comment>).
}
