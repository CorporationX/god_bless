package faang.school.godbless.errors;

import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
        Handling<String> handling = new Handling();
        AtomicReference<Integer> integer = new AtomicReference<>(Integer.valueOf(1234));


        //������ �� ���������
        handling.withErrorHandling(() -> {
                    System.out.println("������� ������ ���������, �������� ���������: ");
                    System.out.println("�������� ��: " + integer);
                    integer.updateAndGet(v -> v - 123);
                    System.out.println("�������� �����: " + integer);
                    return "nice";
                },
                e -> "not nice"
        );

        //������ ���������
        handling.withErrorHandling(() -> {
                    throw new RuntimeException();
                },
                e -> {
                    System.out.println("��������� ������ ���������, �������� ���������: ");
                    System.out.println("�������� ��: " + integer);
                    integer.updateAndGet(v -> v - 123);
                    System.out.println("�������� �����: " + integer);
                    return "not nice";
                }
        );
    }
}

