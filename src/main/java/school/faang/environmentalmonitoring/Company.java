package school.faang.environmentalmonitoring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    private int id;
    private String companyName;
    private int totalEmployees;
}