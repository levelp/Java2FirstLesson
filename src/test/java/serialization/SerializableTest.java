package serialization;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class SerializableTest extends Assert {

    @Test
    public void testSimpleSaveLoad() throws Exception {
        Task task = new Task();
        task.name = "Изучить сериализацию";
        task.priority = 4;
        // Сохраняем в файл
        String fileName = "binary.dat";
        try (ObjectOutputStream s = new ObjectOutputStream(new FileOutputStream(fileName))) {
            s.writeObject(task);
        }
        // Загружаем из файла
        try (ObjectInputStream s = new ObjectInputStream(new FileInputStream(fileName))) {
            Task taskCopy = (Task) s.readObject();
            assertEquals(task.name, taskCopy.name);
            assertEquals(task.priority, taskCopy.priority);
        }

    }

    // Если убрать static - нельзя будет сериализовать
    private static class Task implements Serializable {
        private String name;
        private int priority;
    }
}
