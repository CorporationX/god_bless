package Sprint_3_Task_Analiz;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor

public class UserAction {
    private int id;
    private String userName;
    private ActionType actionType;
    private LocalDate actionDate;
    private String content;


}

