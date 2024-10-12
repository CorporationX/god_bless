package job_analyzer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    private String position;
    private List<String> requirements;
    private int salary;
    private String location;
    private String datePosted;

    /**
     * Parse the date posted as a string into a LocalDate object.
     *
     * @return LocalDate object parsed from the date posted string
     */
    public LocalDate getDatePostedAsLocalDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(this.datePosted, formatter);
    }

    /**
     * Returns the year of the date posted.
     *
     * @return the year of the date posted
     */
    public int getYear() {
        return getDatePostedAsLocalDate().getYear();
    }

    /**
     * Returns the month value of the date posted.
     *
     * @return the month value of the date posted
     */
    public int getMonthValue() {
        return getDatePostedAsLocalDate().getMonthValue();
    }
}
