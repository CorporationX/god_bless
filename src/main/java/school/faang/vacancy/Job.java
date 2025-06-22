package school.faang.vacancy;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;

/**
 * @author Danil Pudovkin
 * @since 21.06.2025
 */
@Data
@ToString
@EqualsAndHashCode
public class Job {

    /**
     * Название позиции
     */
    private String position;

    /**
     * Список навыков
     */
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<String> requirements;

    /**
     * Предлагаемая зарплата
     */
    private double salary;

    /**
     * Местоположение
     */
    private String location;

    /**
     * Дата публикации вакансии
     */
    private String datePosted;
}
