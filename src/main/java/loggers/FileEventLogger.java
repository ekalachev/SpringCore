package loggers;

import beans.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {
    private final String filename;
    private File file;

    public FileEventLogger(String filename) {
        this.filename = filename;
    }

    protected void init() throws IOException {
        this.file = new File(filename);
        this.file.canRead();
    }

    public void logEvent(Event event) {
        File file = new File(filename);

        try {
            FileUtils.writeStringToFile(file, event.toString(), true);
        } catch (Exception e) {

        }
    }
}
