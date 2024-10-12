package bjs2_35433;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserAction {
    private Integer id;
    private String name;
    private String actionType;
    private LocalDate actionDate;
    private String content;
}
