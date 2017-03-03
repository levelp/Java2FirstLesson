package serialization;

import org.junit.Test;

import javax.swing.*;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Сохранение в XML-файл
 */
public class XMLSerialize {


    public static void main(String[] args) throws FileNotFoundException {
        XMLEncoder e = new XMLEncoder(
                new BufferedOutputStream(
                        new FileOutputStream("Test.xml")
                )
        );
        e.writeObject(new JButton("Hello, world"));
        e.close();
    }

    @Test
    public void test() throws FileNotFoundException {
        XMLEncoder e = new XMLEncoder(
                new BufferedOutputStream(
                        new FileOutputStream("Test.xml")
                )
        );
        e.writeObject(new JButton("Hello, world"));
        e.close();
    }
}
