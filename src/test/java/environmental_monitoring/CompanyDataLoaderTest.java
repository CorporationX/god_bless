package environmental_monitoring;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CompanyDataLoaderTest {
    private final CompanyDataLoader dataLoader = new CompanyDataLoader();

    @Test
    void loadEnvironmentalImpacts() {
        List<EnvironmentalImpact> impacts = dataLoader.loadEnvironmentalImpacts("environmental_impact_100.csv");

        assertEquals(100, impacts.size());
        assertEquals(1, impacts.get(0).getId());
        assertEquals(101, impacts.get(0).getCompanyId());
        assertEquals(13939.19, impacts.get(0).getVolume());
        assertEquals("2022-05-30", impacts.get(0).getDate().toString());
        assertEquals(ImpactType.GAS_EMISSION, impacts.get(0).getType());
    }
}