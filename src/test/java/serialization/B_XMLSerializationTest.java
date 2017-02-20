package serialization;

import model.Task;
import org.junit.Assert;
import org.junit.Test;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;

// ВАРИАНТЫ СЕРИАЛИЗАЦИИ:
// ======================
// 1. Бинарный формат
// 2. XML
// 3. JSON (gson)
public class B_XMLSerializationTest extends Assert {

    /**
     * Сохраняем и загружаем в формате XML
     */
    @Test
    public void testXMLSaveLoad() throws Exception {
        Task task = new Task();
        task.name = "Изучить сериализацию в бинарный формат";
        task.priority = 4;
        // Сохраняем в файл
        String fileName = "tasks.xml";
        try (XMLEncoder s = new XMLEncoder(
                new FileOutputStream(fileName))) {
            s.writeObject(task);
        } // .close()
        // Загружаем из файла
        try (XMLDecoder s = new XMLDecoder(new FileInputStream(fileName))) {
            Task taskCopy = (Task) s.readObject();
            assertEquals(task.name, taskCopy.name);
            assertEquals(task.priority, taskCopy.priority);
        }
    }
}
