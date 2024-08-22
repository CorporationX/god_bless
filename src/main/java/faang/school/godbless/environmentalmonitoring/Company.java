package faang.school.godbless.environmentalmonitoring;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Company {
    private long id;
    private String companyName;
    private int totalEmployees;
}