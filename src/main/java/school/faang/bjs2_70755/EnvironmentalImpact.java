package school.faang.bjs2_70755;

import java.time.LocalDate;

public record EnvironmentalImpact(long id,
                                  long companyId,
                                  double volume,
                                  LocalDate date,
                                  EnvironmentalImpactType type) {
}
