package de.exxcellent.challenge.resolution;

import de.exxcellent.challenge.processing.FileObjectRepresentative;
import de.exxcellent.challenge.processing.FileProcessor;
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

    public Challenge(String filePath, String outputColumn, String minuendColumn, String subtractiveColumn) {
        CSVReader csvReader = new CSVReader();
        List<List<String>> fileContent = csvReader.readFile(filePath);

        if (fileContent != null) {
            this.fileProcessor = new FileProcessor(fileContent, outputColumn, minuendColumn, subtractiveColumn);
        }
    }

    /**
     * Returns the column with the smallest spread value.
     *
     * @return String of the column with the smallest value
     */
    public String returnSmallestSpread() {
        List<FileObjectRepresentative> processedObjects = this.fileProcessor.getFileObjectRepresentativeList();

        Collections.sort(processedObjects);
        return String.valueOf(processedObjects.get(0).getOutputValue());
    }
}
