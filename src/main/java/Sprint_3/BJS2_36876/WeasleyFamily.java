    package Sprint_3.BJS2_36876;

    import java.util.concurrent.ExecutorService;
    import java.util.concurrent.Executors;

    public class WeasleyFamily {

        private String[] chores = {"помыть посуду", "подмести пол", "приготовить ужин"};

        public void performChores(){
            ExecutorService executorService = Executors.newCachedThreadPool();

            for (String chore : chores) {
                Chore choreTask = new Chore(chore);
                executorService.submit(choreTask);
            }
            executorService.shutdown();

        }

        public static void main(String[] args) {
        WeasleyFamily weasleyFamily = new WeasleyFamily();
        weasleyFamily.performChores();
        }

    }
