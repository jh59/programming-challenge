package de.exxcellent.challenge.resolution;

import de.exxcellent.challenge.processing.FileProcessor;
import de.exxcellent.challenge.processing.Weather;
import de.exxcellent.challenge.reader.CSVReader;

import java.util.Collections;
import java.util.List;

/**
 * Performs the analysis for the programming challenge.
 *
 * @author Jessica Hohn
 */
public class Challenge {

    private FileProcessor fileProcessor;

    public Challenge(String filePath) {
        CSVReader csvReader = new CSVReader();
        List<List<String>> fileContent = csvReader.readFile(filePath);

        if (fileContent != null) {
            this.fileProcessor = new FileProcessor(fileContent);
        }
    }

    /**
     * Returns the day with the smallest value.
     *
     * @return String of the day with the smallest value
     */
    public String returnSmallestSpread() {
        List<Weather> processedObjects = this.fileProcessor.getProcessedObjects();

        Collections.sort(processedObjects);
        return String.valueOf(processedObjects.get(0).getDay());
    }
}
