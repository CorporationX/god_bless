package JobAnalyzer;

import java.time.LocalDateTime;
import java.util.List;

public record Job (String vocation, List<String> requirements, int salary, String location, LocalDateTime date) {
}
