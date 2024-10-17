Вы — разработчик приложения GMail и сейчас работаете над функцией, которая позволит пользователям настраивать фильтры
для входящих писем. Задача — создать систему, которая будет фильтровать, обрабатывать и преобразовывать письма с
использованием функциональных интерфейсов: Predicate, Consumer, и Function.

Цель:

Создайте класс EmailProcessor, который будет применять Predicate для фильтрации писем, Consumer для их обработки и
Function для преобразования.

Требования:

1. Создайте класс **Email** с полями:

- **subject** — тема письма;
- **body** — текст письма;
- **isImportant** — флаг, указывающий, важное письмо или нет.

2. Создайте класс EmailProcessor с методом processEmails.

3. Метод **processEmails** должен:

- принимать список входящих писем;
- фильтровать их с помощью Predicate<Email>
- преобразовывать тело письма с помощью Function<Email, String>.
- обрабатывать каждое письмо с помощью Consumer<Email>

4. Создайте несколько лямбда-выражений для **Predicate**, **Consumer**, и **Function**, чтобы настроить фильтрацию и
   обработку писем по вашему выбору.

5. Протестируйте систему, обрабатывая несколько писем и выводя результаты в консоль.

Пример использования:

```
EmailProcessor emailProcessor = new EmailProcessor();

// Список входящих писем
List<Email> emails = Arrays.asList(
new Email("Письмо 1", "Текст письма 1", false),
new Email("Письмо 2", "Текст письма 2", true),
new Email("Спам", "Текст спама", false)
);

// Фильтр, который пропускает только важные письма
Predicate<Email> importantFilter = email -> email.isImportant();

// Обработчик, который выводит тему письма в консоль
Consumer<Email> printEmail = email -> System.out.println("Обработано письмо: " + email.getSubject());

// Преобразователь, который переводит текст письма в верхний регистр и сохраняет изменения
Function<Email, String> toUpperCase = email -> {
email.setBody(email.getBody().toUpperCase());
return email.getBody();  // Возвращает преобразованный текст
};

// Обработка писем
emailProcessor.processEmails(emails, importantFilter, printEmail, toUpperCase);

// Выводим обновленные письма, чтобы убедиться, что изменения сохранились
emails.forEach(email -> System.out.println("Тема: " + email.getSubject() + ", Тело письма: " + email.getBody()));

```