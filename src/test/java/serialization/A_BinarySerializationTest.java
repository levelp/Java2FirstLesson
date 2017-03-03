package serialization;

import model.Task;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// ВАРИАНТЫ СЕРИАЛИЗАЦИИ:
// ======================
// 1. Бинарный формат
// 2. XML
// 3. JSON (gson)
public class A_BinarySerializationTest extends Assert {

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
}
