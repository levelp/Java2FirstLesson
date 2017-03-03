package model;

import java.io.Serializable;

// Если убрать static - нельзя будет сериализовать
// Serializable - интерфейс-маркер = пустой, без методов
//   Маркерами мы помечаем свои "обещания" другим программистам
// Serializable - обещаю что мой класс можно
// сохранить и загрузить обратно и всё будет корректно работать.
// Записываются и считываются все поля
public class Task implements Serializable {
    public int priority;
    public String name;
    // transient
    transient int noSaveLoad; // Не сохраняется и не загружается

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public Task() {
    }
}