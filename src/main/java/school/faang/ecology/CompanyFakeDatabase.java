package school.faang.ecology;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import school.faang.ecology.domain.Company;
import school.faang.ecology.exception.CompanyNotFoundException;

import java.util.Map;

/**
 * @author Danil Pudovkin
 * @since 21.06.2025
 */
@Slf4j
@NoArgsConstructor
public class CompanyFakeDatabase {
    
    private final Map<Integer, Company> companies = Map.of(
            101, new Company(101, "EcoCompany", 100),
            102, new Company(102, "PollutingCo", 90),
            103, new Company(103, "SuperCompany", 110),
            104, new Company(104, "GreenCompany", 70),
            105, new Company(104, "RusEcoCompany", 99)
    );
    
    public Company getById(int id) throws CompanyNotFoundException {
        var company = companies.get(id);
        if (company == null) {
            throw new CompanyNotFoundException(id);
        }
        return company;
    }
}
