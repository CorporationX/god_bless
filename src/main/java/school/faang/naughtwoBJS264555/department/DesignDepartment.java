package school.faang.naughtwoBJS264555.department;

import school.faang.naughtwoBJS264555.resources.DesignResources;
import school.faang.naughtwoBJS264555.resources.Resources;

public class DesignDepartment extends Department {
    public DesignDepartment(DesignResources designResources, Resources resourcesOfAnother) {
        super(designResources, resourcesOfAnother);
    }
}
//оставила Resources resourcesOfAnother потому что потенциально департаментов может стать больше
//и взаимодействовать придется не только с имеющимся
