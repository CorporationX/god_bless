package school.faang.sprint2.rating;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class UserAction {
    private int id;
    private String name;
    private String actionType; //= List.of("post", "comment", "like", "share");
    private LocalDate actionDate;
    private String content;

}
