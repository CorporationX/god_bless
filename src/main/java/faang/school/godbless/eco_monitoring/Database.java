package faang.school.godbless.eco_monitoring;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Database {
    private Map<Integer, Company> idAndCompanyMap = new HashMap<>();
}
