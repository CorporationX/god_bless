package faang.school.godbless.threewizardstournament3133;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Student {
    private String name;
    private int year;
    @Setter private int points;

    @Override
    public String toString() {
        return String.format("{%s | year: %d | points earned: %d}",
                this.getName(), this.getYear(), this.getPoints());
    }
}
