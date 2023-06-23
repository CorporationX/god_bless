package faang.school.godbless.sprint2.activity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;



@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private actionType actionType;
    private LocalDateTime actionDate;
    private String content;


}
