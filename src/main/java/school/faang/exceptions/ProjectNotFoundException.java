package school.faang.exceptions;

public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException(int projectId) {
        super("Project with ID " + projectId + " was not found.");
    }

    public ProjectNotFoundException(int projectId, String additionalInfo) {
        super("Project with ID " + projectId + " was not found. " + additionalInfo);
    }
}

