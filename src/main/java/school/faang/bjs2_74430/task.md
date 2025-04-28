## Описание ##
Представьте, что вы работаете в компании Stripe и вам нужно интегрировать свою систему с сервисом обработки платежей MasterCard. Ваша задача — создать программу, которая обрабатывает платежи и отправляет аналитику одновременно, но выполняет их параллельно.
## Цель: ##
Создайте программу, которая выполняет асинхронные операции оплаты и отправки аналитики, используя классы Future и CompletableFuture.
## Требования: ##
1. Создайте класс MasterCardService, который содержит два метода:<br/>
collectPayment(): имитирует процесс оплаты и возвращает результат через 10 секунд.<br/>
sendAnalytics(): имитирует процесс отправки аналитики и возвращает результат через 1 секунду.
2. Реализуйте метод doAll в вашем классе:<br/>
Запустите метод collectPayment() в отдельном потоке и получите результат через Future.<br/>
Запустите метод sendAnalytics() асинхронно через CompletableFuture.<br/>
Основной поток должен сначала дождаться завершения отправки аналитики и вывести результат.<br/>
После этого основной поток должен дождаться завершения обработки платежа и вывести результат.<br/>
3. В качестве шаблона для методов collectPayment и sendAnalytics используйте следующий код:<br/>
```
private static final int TEN_SECONDS_IN_MS = 10_000; 
private static final int ONE_SECOND_IN_MS = 1_000;

static int collectPayment() {
    try {
        Thread.sleep(TEN_SECONDS_IN_MS);
        return 5_000;
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new RuntimeException(e);
    }
}

static int sendAnalytics() {
    try {
        Thread.sleep(ONE_SECOND_IN_MS);
        return 17_000;
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new RuntimeException(e);
    }
} 
```
4. Важно: избегайте использования Thread.sleep в основном потоке для ожидания завершения операций. Используйте методы 
классов Future и CompletableFuture, чтобы дождаться завершения каждой задачи.
### Пример использования: ###
```
MasterCardService service = new MasterCardService();
service.doAll();
```
### Ожидаемый вывод: ###
```
Аналитика отправлена: 17000
Платеж выполнен: 5000
```