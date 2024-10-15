package faang.school.godbless.streamapi.analyze;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserAction {
    @NonNull
    private Integer id;
    @NonNull
    private String name;
    @NonNull
    private String actionType;
    @NonNull
    private LocalDate actionDate;
    @NonNull
    private String content;
}
