package LinkID_analizator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.stream.Location;
import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@Getter
@ToString
@Setter
public class Job {
    private String title;
    private List<String> requirements;
    private int salary;
    private Location location;
    private LocalDate dateAdded;
}
