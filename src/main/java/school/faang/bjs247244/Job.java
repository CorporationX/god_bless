package school.faang.bjs247244;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class Job {
    private String position;// — название позиции,
    private List<String> requirements;//  — список навыков (List<String>),
    private String salary;//  — предлагаемая зарплата,
    private String location;//  — местоположение,
    private String datePosted;// — дата публикации вакансии.
}


