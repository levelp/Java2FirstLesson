package util;

import dao.XMLFile;
import model.Person;

import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Вспомогательный класс, который умеет сохранять и загружать наш объект
 */
public class MyClassHelper {
    /**
     * Запись объекта в XML-файл
     *
     * @param obj      объект
     * @param filename имя файла
     * @throws Exception
     */
    public static void write(Object obj, String filename) throws FileNotFoundException {
        System.out.println("Save to: \"" + filename + "\"");
        /*XMLEncoder encoder =
                new XMLEncoder(
                        new BufferedOutputStream(
                                new FileOutputStream(filename))); */
        XMLEncoder encoder =
                new XMLEncoder(new FileOutputStream(filename));
        encoder.writeObject(obj);
        encoder.close();
    }

    public static Person read(String filename) throws Exception {
        XMLFile<Person> xmlFile = new XMLFile<Person>();
        return xmlFile.load(filename);
    }
}