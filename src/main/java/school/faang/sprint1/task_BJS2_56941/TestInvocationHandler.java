package school.faang.sprint1.task_BJS2_56941;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TestInvocationHandler implements InvocationHandler {
    private final Library originLibrary;

    public TestInvocationHandler(Library originLibrary) {
        this.originLibrary = originLibrary;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        Object result = null;
        try {
            result = method.invoke(originLibrary, args);
            System.out.println("Исключений нет");
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        return result;
    }
}
