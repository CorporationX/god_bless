package faang.school.godbless.enviromental_monitoring;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Company {
    private int id;
    private String companyName;
    private int totalEmployees;
}