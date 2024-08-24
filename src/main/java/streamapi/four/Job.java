package streamapi.four;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Job {

    private String jobTitle;
    private List<String> requirements;
    private double salary;
    private String location;
    private final LocalDateTime postingDate = LocalDateTime.now();
}
