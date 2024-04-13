package faang.school.godbless.bjs2_5257;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CompanyService {

    private static final Map<Integer, Company> companies = new HashMap<>();

    public CompanyService() {
        Company apple = new Company(51, "Apple", 20000);
        Company amazon = new Company(52, "Amazon", 30000);
        Company alphabet = new Company(53, "Alphabet", 40000);
        Company tesla = new Company(54, "Tesla", 5000);
        Company walmart = new Company(55, "Walmart", 45000);
        Company meta = new Company(56, "Meta", 15000);
        Company shell = new Company(57, "Shell", 50000);
        Company microsoft = new Company(58, "Microsoft", 49000);
        Company visa = new Company(59, "Visa", 11000);
        Company mastercard = new Company(60, "Mastercard", 9000);
        companies.put(apple.getId(), apple);
        companies.put(amazon.getId(), amazon);
        companies.put(alphabet.getId(), alphabet);
        companies.put(tesla.getId(), tesla);
        companies.put(walmart.getId(), walmart);
        companies.put(meta.getId(), meta);
        companies.put(shell.getId(), shell);
        companies.put(microsoft.getId(), microsoft);
        companies.put(visa.getId(), visa);
        companies.put(mastercard.getId(), mastercard);

    }

    public Company findCompanyById(int companyId) {
        return Optional.ofNullable(companies.get(companyId))
                .orElse(new Company(0, "Other company", 0));
    }
}
