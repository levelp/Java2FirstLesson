Java 2: Занятие 1
=================

Maven
-----
* Сборка проекта с помощью Maven
* Конфигурационный файл Maven
* Управление записимостями
* Подключение зависимостей на примере JUnit и Gson

JUnit тесты 
-----------
* Тесты, аннотация: ```@Test```
* ```@Before``` и ```@After```
* ```@BeforeClass``` и ```@AfterClass```
* Проверка исключений ```@Test(expected = ExceptionClassName.class)```

Способы и виды сериализации
---------------------------
* Сериализация: сохраняем класс как данные и 
потом можем его однозначно восстановить.
* Для чего?
  1. Мы хотим обработать объект в другой программе
  2. Сохранение и загрузка объекта
* Сериализация объектов: в бинарный формат, в XML, JSON и т.д.
* Интерфейс ```java.io.Serializable```
* Объектные потоки ввода-вывода
* Условия успешной упаковки и распаковки объектов
* Сериализация в структурные форматы на примере Json

Сериализация = сохранение, Десериализация = загрузка

Подробнее: https://docs.oracle.com/javase/8/docs/technotes/guides/serialization/

Google JSON: https://github.com/google/gson

1. Помечаем класс аннотацией ```Serializable```
```java
public class Task implements Serializable {
   public String name;
   public int priority;
}
```
2. Сохраняем в бинарном формате:
```java
try (ObjectOutputStream s =
    new ObjectOutputStream(
        new FileOutputStream(fileName))) {
           s.writeObject(task);
}
```
3. Загружаем в бинарном формате:
```java
try (ObjectInputStream s =
    new ObjectInputStream(
        new FileInputStream(fileName))) {
           task = (Task) s.readObject();
}
```