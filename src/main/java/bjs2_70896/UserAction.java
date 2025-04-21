package bjs2_70896;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class UserAction {
    private int id;
    private String name;
    private ActionType type;
    private LocalDateTime actionDate;
    private String content;
}
