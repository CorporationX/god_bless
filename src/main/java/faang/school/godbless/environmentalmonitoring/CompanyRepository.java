package faang.school.godbless.environmentalmonitoring;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CompanyRepository {
    private static final Map<Long, Company> COMPANY_MAP = new HashMap<>();

    public CompanyRepository() {
        Company superCompany = new Company(1, "SuperCompany", 5000);
        Company megaCorp = new Company(2, "MegaCorp", 12000);
        Company ecoFuture = new Company(3, "EcoFuture", 8000);
        COMPANY_MAP.put(superCompany.getId(), superCompany);
        COMPANY_MAP.put(megaCorp.getId(), megaCorp);
        COMPANY_MAP.put(ecoFuture.getId(), ecoFuture);
    }

    public Company findCompanyById(long companyId) {
        return Optional.ofNullable(COMPANY_MAP.get(companyId))
                .orElse(new Company(0, "Other company", 0));
    }
}