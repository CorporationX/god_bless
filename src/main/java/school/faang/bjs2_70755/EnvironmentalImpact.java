package school.faang.bjs2_70755;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;

@JsonPropertyOrder({"id", "companyId", "volume", "date", "type"})
public record EnvironmentalImpact(long id,
                                  long companyId,
                                  double volume,
                                  @JsonFormat(pattern = "yyyy.MM.dd")
                                  LocalDate date,
                                  EnvironmentalImpactType type) {
}
