package de.exxcellent.challenge.processing;

import java.util.ArrayList;
import java.util.List;

/**
 * Processes a files content.
 *
 * @author Jessica Hohn
 */
public class FileProcessor implements FileProcessorComponent {
    private List<Weather> processedObjects;

    /**
     * Constructor for only solving the weather challenge.
     *
     * @param weatherData file content
     */
    public FileProcessor(List<List<String>> weatherData) {
        processedObjects = new ArrayList<>();
        processFileData(weatherData);
    }

    public List<Weather> getProcessedObjects() {
        return processedObjects;
    }

    /**
     * Process the weather files content to a list of Weather objects.
     *
     * @param fileContent file content as a list of objects
     */
    @Override
    public void processFileData(List<List<String>> fileContent) {
        for (List<String> data :
                fileContent) {
            if (fileContent.indexOf(data) != 0) {
                int day = Integer.parseInt(data.get(0));
                int maxTemp = Integer.parseInt(data.get(1));
                int minTemp = Integer.parseInt(data.get(2));
                processedObjects.add(new Weather(day, maxTemp, minTemp));
            }
        }
    }
}
