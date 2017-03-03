package serialization;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;

// ВАРИАНТЫ СЕРИАЛИЗАЦИИ:
// ======================
// 1. Бинарный формат
// 2. XML
// 3. JSON (gson)
public class SerializableTest extends Assert {

    /**
     * Сохраняем и загружаем в бинарном формате
     */
    @Test
    public void testBinarySaveLoad() throws Exception {
        Task task = new Task();
        task.name = "Изучить сериализацию в бинарный формат";
        task.priority = 4;
        // Сохраняем в файл
        String fileName = "binary.dat";
        try (ObjectOutputStream s =
                     new ObjectOutputStream(
                             new FileOutputStream(fileName))) {
            s.writeObject(task);
            s.writeObject(new Task("Ещё что-то изучить", 3));
        } // .close()
        // Загружаем из файла
        try (ObjectInputStream s = new ObjectInputStream(new FileInputStream(fileName))) {
            Task taskCopy = (Task) s.readObject();
            assertEquals(task.name, taskCopy.name);
            assertEquals(task.priority, taskCopy.priority);
        }
    }

    @Test
    public void testDataStream() throws Exception {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("dos.dat"));
            // ...
            dos.writeDouble(1.1);
            dos.writeInt(122);
            dos.writeLong(3323);
            dos.writeBoolean(true);
        } finally {
            if (dos != null)
                dos.close();
        }
        try (DataInputStream dis = new DataInputStream(new FileInputStream("dos.dat"))) {
            double d = dis.readDouble();
            System.out.println("d = " + d);
            int i = dis.readInt();
            System.out.println("i = " + i);
        }
    }

    /**
     * JSON - текстовый формат обмена данными, основанный на JavaScript
     * Сериалиазация и десериализация объекта из JSON формата
     */
    @Test
    public void testJsonSaveLoad() throws Exception {
        Task task = new Task();
        task.name = "Изучить сериализацию в JSON";
        task.priority = 4;

        // Сохраняем в JSON
        //GsonBuilder builder = new GsonBuilder();
        Gson gson = new Gson(); //builder.create();
        String JSON = gson.toJson(task);
        System.out.println(JSON);

        try (PrintWriter pw = new PrintWriter("tasks.json")) {
            pw.println(gson.toJson(task));
        }

        // Обратно получаем из JSON
        Task taskCopy = gson.fromJson(JSON, Task.class);
        assertEquals(task.name, taskCopy.name);
        assertEquals(task.priority, taskCopy.priority);
    }

    // Если убрать static - нельзя будет сериализовать
    // Serializable - интерфейс-маркер = пустой, без методов
    //   Маркерами мы помечаем свои "обещания" другим программистам
    // Serializable - обещаю что мой класс можно
    // сохранить и загрузить обратно и всё будет корректно работать.
    // Записываются и считываются все поля
    private static class Task implements Serializable {
        protected int priority;
        // transient
        transient int noSaveLoad; // Не сохраняется и не загружается
        private String name;

        public Task(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        public Task() {
        }
    }
}
