package serialization;

import org.junit.Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by dstepule on 03.03.2017.
 */
public class DataOutputStreamTest {


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
}
