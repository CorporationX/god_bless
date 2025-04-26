package school.faang.stream2.ecomonitoring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CompanyList {
    private final List<Company> companyList = new ArrayList<>();

    public static CompanyList of(Company... args) {
        CompanyList result = new CompanyList();
        result.companyList.addAll(Arrays.asList(args));
        return result;
    }

    public Optional<Company> findByCompanyId(int companyId) {
        return companyList.stream()
                .filter(company -> companyId == company.getId())
                .findFirst();
    }

    public Optional<Company> findByCompanyName(String companyName) {
        return companyList.stream()
                .filter(company -> companyName.equals(company.getCompanyName()))
                .findFirst();
    }
}
