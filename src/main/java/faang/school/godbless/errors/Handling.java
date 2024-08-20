package faang.school.godbless.errors;

import java.util.function.Supplier;

//R - ������������  ��� ��� ���������� ������ ��������� � ��� ���������� ��������,
//������������� ��� ������������� ����������
public class Handling<R> {
    public R withErrorHandling(Supplier<R> supplier, ExceptionHandler<R> exceptionHandler) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return exceptionHandler.handle(e);
        }
    }
}
