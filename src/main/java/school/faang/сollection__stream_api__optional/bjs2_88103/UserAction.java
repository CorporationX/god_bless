package school.faang.сollection__stream_api__optional.bjs2_88103;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class UserAction {
    private int userId;
    private String userName;
    private ActionType actionType;
    private LocalDate actionDate;
    private String content;


}
