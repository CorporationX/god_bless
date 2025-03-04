package school.faang.naughtwoBJS264555.department;

import school.faang.naughtwoBJS264555.resources.MarketingResources;
import school.faang.naughtwoBJS264555.resources.Resources;

public class MarketingDepartment extends Department {
    public MarketingDepartment(MarketingResources marketingResources, Resources resourcesOfAnother) {
        super(marketingResources, resourcesOfAnother);
    }
}
//оставила Resources resourcesOfAnother потому что потенциально департаментов может стать больше
//и взаимодействовать придется не только с имеющимся
