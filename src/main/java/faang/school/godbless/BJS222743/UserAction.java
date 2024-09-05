package faang.school.godbless.BJS222743;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class UserAction {
    private Long userId;
    private String username;
    // Будет правильно если через enum написать? Хочется думать про масштабируемость =)
    private String actionType; // like, comment, post, share
    private LocalDate actionDate;
    private String content;
}
