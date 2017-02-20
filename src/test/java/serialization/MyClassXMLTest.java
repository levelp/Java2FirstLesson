package serialization;

import dao.XMLFile;
import model.Person;
import org.junit.Assert;
import org.junit.Test;
import util.MyClassHelper;

import java.io.File;

/**
 * Тестируем сохранение и загрузку
 */
public class MyClassXMLTest extends Assert {

    public static final String FILENAME = "person.xml";

    @Test
    public void testSaveLoad() throws Exception {
        Person f1 = new Person();
        f1.setName("Петя");
        f1.setAge(10);
        //f1.setFinalField(343);
        MyClassHelper.write(f1, FILENAME);

        File f = new File(FILENAME);
        assertTrue(f.exists());
        assertFalse(f.isDirectory());
        assertTrue(new File(FILENAME).isFile());

        // Считываем обратно
        Person f2 = MyClassHelper.read(FILENAME);
        assertEquals(f1.getName(), f2.getName());
        assertEquals(f1.getAge(), f2.getAge());
    }

    @Test
    public void testSaveLoadArrays() throws Exception {
        int array[] = {4, 5, 2, 324};
        String filename = "array.xml";
        MyClassHelper.write(array, filename);

        XMLFile<int[]> xmlFile = new XMLFile<>();
        int array2[] = xmlFile.load(filename);

        assertArrayEquals(array, array2);
    }
}