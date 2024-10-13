package school.faang.socialnetwork;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;


public record UserAction(Integer id,
                         String name,
                         ActionType actionType,
                         LocalDate actionDate,
                         String content) {
}
