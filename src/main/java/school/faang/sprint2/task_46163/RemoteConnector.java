package school.faang.sprint2.task_46163;

public interface RemoteConnector<T> {

    T connect() throws Exception;
}
