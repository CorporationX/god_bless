package school.faang.task47104;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import java.time.LocalDate;
import java.util.List;

public record Job(String position, List<String> requirements,
                  int salary, String location,
                  @JsonSerialize(using = ToStringSerializer.class)
                  @JsonDeserialize(using = LocalDateDeserializer.class)
                  LocalDate datePosted) {
}
