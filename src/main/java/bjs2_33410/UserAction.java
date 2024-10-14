package bjs2_33410;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class UserAction {
    private final int id;
    private String name;
    private String actionType;
    private LocalDate actionDate;
    private String content;
}
