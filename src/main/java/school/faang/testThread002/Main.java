package school.faang.testThread002;

public class Main extends Thread {

    /**
     * Исключение возникает потому, что в вашем примере поток запускается дважды, вызывая метод start() два раза подряд.
     * Согласно спецификации Java, метод `start()` нельзя вызывать повторно для одного и того же
     * объекта потока — попытка сделать это приведет к выбрасыванию исключения IllegalThreadStateException.
     *
     * Вот подробная последовательность шагов программы:
     *
     * 1. Вы создаёте экземпляр класса Main, наследуемого от класса Thread.
     * 2. Затем вызываете первый раз метод m.start(), что создаёт и запускает новый поток исполнения.
     * 3. Далее выводится строка "one.".
     * 4. Потом снова пытаетесь вызвать метод m.start(), хотя поток уже запущен ранее.
     *    - Это является нарушением правил API потоков в Java: один и тот же поток нельзя запустить дважды.
     *
     * Таким образом, выполнение второго вызова метода start() приведёт к исключению вида:
     *
     * Exception in thread "main" java.lang.IllegalThreadStateException
     * ...
     */
    public static void main(String[] args) {
        Main m = new Main();
        m.start();
        System.out.println("one.");
        m.start();
        System.out.println("two.");
    }

    public void run() {
        System.out.println("Thread ");
    }

}
