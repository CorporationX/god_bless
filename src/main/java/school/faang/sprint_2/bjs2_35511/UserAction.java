package school.faang.sprint_2.bjs2_35511;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserAction {
    int id;
    String name;
    String actionType;
    LocalDate actionDate;
    String content;
}
