package faang.school.godbless.Sprint4.TakeComments;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Data
@EqualsAndHashCode
public class Post {
    private String author;
    private LocalDate date;
    private volatile List<Comment> comments = new LinkedList<>();
    private Map<Comment, Integer> idComments = new HashMap<>();

    public Post(String author, LocalDate date, List<Comment> comments) {
        this.author = author;
        this.date = date;
        this.comments = comments;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
        //лучше ограницить кэш, но тогда буду проблемы с проверкой на то, что удален ли уже комент
        idComments.put(comment, comments.size() - 1);
    }

    public void removeComment(Comment comment) {
        if (comments.contains(comment)) {
            comments.set(idComments.get(comment), null);
            idComments.put(comment, null);
        }
    }

    public synchronized boolean updateIdComments() {
        idComments.clear();
        var ref = new Object() {
            int indexComments = 0;
        };
        comments = comments.stream()
                .filter(e -> e != null)
                .peek(e -> idComments.put(e, ref.indexComments++))
                .toList();
        return true;
    }

    public Post(String author, LocalDate date) {
        this.author = author;
        this.date = date;
    }
}
