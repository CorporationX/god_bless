package school.faang.task_44919;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@ToString
public class Employee {
    private int id;
    private String name;
    private Set<String> skills;
    private List<Project> projects; // сам добавил, так как для решения BalancedTeamAssignmentStrategy не хватает данных
    // чтоб решить ее нужны доп данные:
    // 1) либо как я добавил лист проектов у каждого сотрудника
    // 2) либо как-то отдавать все проекты в метод assignTeam
    // 3) может есть и другие варианты но у меня пока нет мыслей


    public Employee(int id, String name, Set<String> skills) {
        this.id = id;
        this.name = name;
        this.skills = skills;
        this.projects = new ArrayList<>();
    }
}
