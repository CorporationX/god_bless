package school.faang.asynchrony;

/**
 * Проект: god_bless
 * Класс AppRunner
 * Автор: Vital
 */

public class AppRunner {
    public static void main(String[] args) {
        MasterCardService service = new MasterCardService();
        service.doAll();
    }
}