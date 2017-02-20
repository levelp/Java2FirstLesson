package serialization;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;

public class TextFileSaveLoad extends Assert {

    @Test
    public void test() throws IOException {
        int a[] = {2, 4, 35};
        // Запись в текстовый файл
        try (PrintWriter writer = new PrintWriter("text.txt")) {
            writer.println("This is first string");
            writer.println("A = 2");
            writer.println(a.length);
            for (int x : a) {
                writer.println(x);
            }
        }
        // Чтение из текстового файла
        try (Scanner scanner = new Scanner(new File("text.txt"))) {
            String firstLine = scanner.nextLine();
            System.out.println("firstLine = " + firstLine);
            String varName = scanner.next().trim();
            String equals = scanner.next().trim();
            int value = scanner.nextInt();
            System.out.println("varName = \"" + varName + "\"");
            System.out.println("equals = \"" + equals + "\"");
            System.out.println("value = " + value);

            // Считываем элементы массива
            int arrayLength = scanner.nextInt();
            int aNew[] = new int[arrayLength];
            for (int i = 0; i < arrayLength; i++) {
                aNew[i] = scanner.nextInt();
            }
            assertEquals(a.length, aNew.length);
            assertArrayEquals(a, aNew);
        }

        try (FileReader fileReader = new FileReader("text.txt")) {
            StreamTokenizer tokenizer = new StreamTokenizer(fileReader);
            tokenizer.nextToken();
            String value = tokenizer.sval;
            System.out.println("value = " + value);
        }
    }
}
