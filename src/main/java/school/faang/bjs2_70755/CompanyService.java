package school.faang.bjs2_70755;

import lombok.experimental.UtilityClass;

import java.util.Map;

import static school.faang.bjs2_70755.CompanyName.AMAZON;
import static school.faang.bjs2_70755.CompanyName.APPLE;
import static school.faang.bjs2_70755.CompanyName.GOOGLE;
import static school.faang.bjs2_70755.CompanyName.META;
import static school.faang.bjs2_70755.CompanyName.NVIDIA;

@UtilityClass
public class CompanyService {

    private static final Map<Long, Company> COMPANY_DB = Map.of(
            101L, new Company(101L, GOOGLE, 10000),
            102L, new Company(102L, AMAZON, 20000),
            103L, new Company(103L, APPLE, 30000),
            104L, new Company(104L, META, 40000),
            105L, new Company(105L, NVIDIA, 500030));

    public static Company getCompanyById(long companyId) {
        Company company = COMPANY_DB.get(companyId);
        if (company == null) {
            throw new CompanyNotFoundException(companyId);
        }
        return company;
    }
}
