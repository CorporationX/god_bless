package school.faang.projectteammanagement;

import java.util.List;

public class ProjectManager {

  /*  Хранит списки
    сотрудников компании
    и проектов.*/
    List<Project> companyProjects;
    List<Employee> allEmployees;
    TeamAssignmentStrategy activeStrategy;


    //    Имеет метод  для выбора стратегии распределения сотрудников.
    public void setAssignmentStrategy(TeamAssignmentStrategy strategy) {
    }

    //    Реализует метод    ,который применяет выбранную стратегию для назначения команды на проект.
    public void assignTeamToProject(int projectId) {
    }

    //    Поддерживает метод    ,возвращающий список сотрудников,назначенных на проект.
    public void getTeamForProject(int projectId) {
    }
}
