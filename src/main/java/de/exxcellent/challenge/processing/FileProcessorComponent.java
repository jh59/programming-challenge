package de.exxcellent.challenge.processing;

import java.util.List;

/**
 * Component to process file content.
 *
 * @author Jessica Hohn
 */
public interface FileProcessorComponent {

    void processFileData(List<List<String>> fileContent);
}
