package faang.school.godbless.ActiveUsersCheck;
import java.util.List;

@FunctionalInterface
public interface TopicProvider {
    List<String> getTopics();
}