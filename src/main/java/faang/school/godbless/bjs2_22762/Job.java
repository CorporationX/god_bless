package faang.school.godbless.bjs2_22762;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@ToString
@Getter
@AllArgsConstructor
public class Job {
    private String title;
    private List<String> requirements;
    private int salary;
    private String location;
    private LocalDate datePosted;

    public boolean isPostedAfterInclusive(LocalDate date) {
        return datePosted.isEqual(date) || datePosted.isAfter(date);
    }

    public boolean isPostedBeforeInclusive(LocalDate date) {
        return datePosted.isBefore(date) || datePosted.isEqual(date);
    }

    public boolean isPostedBetweenInclusive(LocalDate startDate, LocalDate endDate) {
        return isPostedAfterInclusive(startDate) && isPostedBeforeInclusive(endDate);
    }
}
