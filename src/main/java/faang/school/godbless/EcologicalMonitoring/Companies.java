package faang.school.godbless.EcologicalMonitoring;

import java.util.List;

public class Companies {
    public static final List<Company> COMPANIES = List.of(new Company(1, "Google", 100),
            new Company(2, "Meta", 120),
            new Company(3, "Amazon", 140),
            new Company(4, "Uber", 160),
            new Company(5, "Netflix", 80));

    public static Company getById(int id){
        return COMPANIES.get(id - 1);
    }
}
