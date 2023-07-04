import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CashierThread extends Thread {
    private int cashierId;
    private List<Integer> customerItems;

    @Override
    public void run() {
        System.out.println("Продавец ID=" + cashierId + " обработал " + customerItems.size() + " общей стоимостью " + customerItems.stream().mapToInt(Integer::intValue).sum());
    }
}
