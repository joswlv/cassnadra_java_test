package cleanupTest;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Jo_seungwan on 2017. 4. 23..
 */
public class FileWriterEAM implements AutoCloseable{
    private final FileWriter writer;

    private FileWriterEAM(final String fileName) throws IOException {
        writer = new FileWriter(fileName);
    }

    public void writeStuff(final String message) throws IOException {
        writer.write(message);
    }

    public void close() throws Exception {
        System.out.println("Close 호출됨");
        writer.close();
    }

    public static void use(final String fileName, final UseInstance<FileWriterEAM, IOException> block) throws Exception {

        try (FileWriterEAM writerEAM = new FileWriterEAM(fileName)) {
            block.accept(writerEAM);
        }
    }

    public static void main(String[] args) throws Exception {
        FileWriterEAM.use("eam.txt",writerEAM -> writerEAM.writeStuff("GOOD!!"));
    }
}
