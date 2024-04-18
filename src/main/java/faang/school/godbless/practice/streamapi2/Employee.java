package faang.school.godbless.practice.streamapi2;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class Employee {
    private final String name;
    private final int salary;
    private final String department;
}
