package faang.school.godbless.BJS2_23000;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
public class JobDifferencePerDay implements JobDifference {

    @Override
    public Map<LocalDate, Difference> calculateDifference(
            LocalDate startDate, LocalDate endDate, Map<LocalDate, Difference> differencePerDay) {
        return Stream.iterate(
                startDate,
                date -> date.isBefore(endDate),
                date -> date.plusDays(1L))
                .map(date -> differencePerDay.getOrDefault(date, new Difference(date)))
                .collect(Collectors.toMap(Difference::getDate, difference -> difference));
    }
}
