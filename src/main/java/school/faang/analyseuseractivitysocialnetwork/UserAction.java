package school.faang.analyseuseractivitysocialnetwork;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class UserAction {

    int id;
    String name;
    String actionType;
    LocalDate actionDate;
    String content;

}
