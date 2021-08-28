package de.exxcellent.challenge.processing;

import java.util.ArrayList;
import java.util.List;

/**
 * Processes a files content.
 *
 * @author Jessica Hohn
 */
public class FileProcessor implements FileProcessorComponent{
    private List<Weather> processedObjects;

    /**
     * Constructor for only solving the weather challenge.
     * @param weatherData file content
     */
    public FileProcessor(List<List<String>> weatherData){
        processedObjects = new ArrayList<>();
    }

    public List<Weather> getProcessedObjects() {
        return processedObjects;
    }

    @Override
    public void processFileData(List<List<String>> fileContent) {

    }
}
