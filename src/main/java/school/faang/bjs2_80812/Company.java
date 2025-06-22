package school.faang.bjs2_80812;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    private int id;
    private String companyName;
    private int totalEmployees;
}
