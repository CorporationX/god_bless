package school.faang.sprint_1.task_44926.repository;

import school.faang.sprint_1.task_44926.entity.Project;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class ProjectRepository {
    private static final Set<Project> projects = new HashSet<>();

    public void addProject(Project project) {
        projects.add(project);
    }

    public void removeProject(Project project) {
        projects.remove(project);
    }

    public Project getProjectById(int id) {
        return projects.stream()
                .filter(project -> project.getId() == id)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public Set<Project> getAllProjects() {
        return Set.copyOf(projects);
    }
}
