package school.faang.triwizardtournament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    @NonNull
    private final String name;
    private final int year;
    private int points;
}
