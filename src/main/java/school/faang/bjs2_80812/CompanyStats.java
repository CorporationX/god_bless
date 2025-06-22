package school.faang.bjs2_80812;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyStats {
    private String name;
    private double totalEmission;
    private double avgEmission;
    private double minEmission;
}
