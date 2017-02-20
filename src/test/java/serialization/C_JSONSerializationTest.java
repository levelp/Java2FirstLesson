package serialization;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Task;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileReader;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Сохранение и загрузка в формате JSON
 */
public class C_JSONSerializationTest extends Assert {

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
        Gson gson = new Gson();
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

    /**
     * JSON - текстовый формат обмена данными, основанный на JavaScript
     * Сериалиазация и десериализация объекта из JSON формата
     */
    @Test
    public void testTaskListSaveLoad() throws Exception {
        List<Task> tasks = new TaskList();
        tasks.add(new Task("Изучить сериализацию в JSON", 4));

        // Сохраняем в JSON
        Gson gson = new Gson();
        String JSON = gson.toJson(tasks);
        System.out.println(JSON);

        try (PrintWriter pw = new PrintWriter("tasks.json")) {
            pw.println(gson.toJson(tasks));
        }

        // Обратно получаем из JSON
        try (FileReader in = new FileReader("tasks.json")) {
            Type collectionType = new TypeToken<List<Task>>() {
            }.getType();
            List<Task> tasksCopy = gson.fromJson(in, collectionType);
        }

        try (FileReader in = new FileReader("tasks.json")) {
            TaskList tasksCopy = gson.fromJson(in, TaskList.class);
        }
    }


    public static class TaskList extends ArrayList<Task> {
    }
}
