package serialization;

import org.junit.Test;

import javax.swing.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

/**
 * Сохранение в XML-файл
 */
public class XMLSerialize {


    public static void main(String[] args) throws FileNotFoundException {
        try (XMLEncoder e = new XMLEncoder(
                new BufferedOutputStream(
                        new FileOutputStream("Point.xml")
                )
        )) {
            Point p = new Point(1, 2);
            e.writeObject(p);
        }

        try (XMLDecoder decoder = new XMLDecoder(
                new FileInputStream("Point.xml"))) {
            Point p2 = (Point) decoder.readObject();
            System.out.println("p2 = " + p2);
        }
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

    public static class Point implements Serializable {
        public int x;
        public int y;

        public Point() {

        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
