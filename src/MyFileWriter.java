import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class that write info in file
 **/
public class MyFileWriter {

    private final BufferedWriter bufferedWriter;

    public MyFileWriter(String path) throws IOException {

        FileWriter file = new FileWriter(path);
        this.bufferedWriter = new BufferedWriter(file);

    }

    /**
     * Write info in file
     * @param info Info to write
     */
    public void writeInFileInfo(String info) throws IOException {

            this.bufferedWriter.write(info);

    }

    /**
     * Close BufferedWriter
     */
    public void closeBuffer() throws IOException {
        this.bufferedWriter.close();
    }

}
