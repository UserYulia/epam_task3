package by.galkina.restaurant.reader;

import by.galkina.restaurant.exception.WrongFileNameException;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TxtFileReader {
    public static final Logger LOG = Logger.getLogger(TxtFileReader.class);

    public static List<String> readData(String path) throws WrongFileNameException {
        List<String> data = new ArrayList<>();
        try {
            Files.lines(Paths.get(path)).forEach(data::add);
            LOG.info("File " + path + " successfully read.");
        } catch (IOException e) {
            LOG.fatal("File not found");
            throw new RuntimeException();
        }
        return Collections.unmodifiableList(data);
    }
}
