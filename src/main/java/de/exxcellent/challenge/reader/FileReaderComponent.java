package de.exxcellent.challenge.reader;

import java.util.List;

/**
 * Component to read files.
 *
 * @author Jessica Hohn
 */
public interface FileReaderComponent {

    List<List<String>> readFile(String filePath);

    boolean fileIsValid(List<List<String>> fileContent);
}
