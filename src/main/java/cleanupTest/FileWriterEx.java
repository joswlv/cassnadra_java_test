package cleanupTest;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Jo_seungwan on 2017. 4. 23..
 */
public class FileWriterEx implements AutoCloseable{
    private final FileWriter writer;

    public FileWriterEx(final String fileName) throws IOException {
        writer = new FileWriter(fileName);
    }

    public void writeStuff(final String message) throws IOException {
        writer.write(message);
    }

    public void close() throws IOException {
        System.out.println("Close호출됨!");
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        try (FileWriterEx writer = new FileWriterEx("joswlv.txt")) {
            writer.writeStuff("TEST-TEST");
        }
    }
}