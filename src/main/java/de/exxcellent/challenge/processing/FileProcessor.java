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

    // needed for generalized processing
    private List<FileObjectRepresentative> fileObjectRepresentativeList;
    private String outputColumn;
    private String minuendColumn;
    private String subtractiveColumn;

    /**
     * Constructor for only solving the weather challenge.
     *
     * @param weatherData file content
     */
    public FileProcessor(List<List<String>> weatherData) {
        processedObjects = new ArrayList<>();
        processWeatherData(weatherData);
    }

    /**
     * Constructor to solve spread challenge of similar type (e.g. weather and football challenge).
     *
     * @param fileContent       the file containing the data to be processed
     * @param outputColumn      name of the column which should be returned as result
     * @param minuendColumn     name of the first column for absolute difference calculation
     * @param subtractiveColumn name of the second column for absolute difference calculation
     */
    public FileProcessor(List<List<String>> fileContent, String outputColumn, String minuendColumn, String subtractiveColumn) {
        this.outputColumn = outputColumn;
        this.minuendColumn = minuendColumn;
        this.subtractiveColumn = subtractiveColumn;

        fileObjectRepresentativeList = new ArrayList<>();
        processFileData(fileContent);
    }

    /**
     * Getter for list of generated Weather objects
     *
     * @return list with Weather objects
     */
    public List<Weather> getProcessedObjects() {
        return processedObjects;
    }

    /**
     * Getter for list of generated FileObjectRepresentative objects.
     *
     * @return list with FileObjectRepresentative objects.
     */
    public List<FileObjectRepresentative> getFileObjectRepresentativeList() {
        return fileObjectRepresentativeList;
    }

    /**
     * Process a files content to a list of content representative objects.
     *
     * @param fileContent file content as list of objects
     */
    @Override
    public void processFileData(List<List<String>> fileContent) {
        List<String> firstRow = fileContent.get(0);
        if (columnExists(firstRow, outputColumn) && columnExists(firstRow, minuendColumn) && columnExists(firstRow, subtractiveColumn)) {
            // determine column indices
            int outputIndex = firstRow.indexOf(outputColumn);
            int minuendIndex = firstRow.indexOf(minuendColumn);
            int subtractiveIndex = firstRow.indexOf(subtractiveColumn);

            // create file object representatives
            for (List<String> data :
                    fileContent) {
                if (fileContent.indexOf(data) != 0) {
                    generateFileObjectRepresentative(data, outputIndex, minuendIndex, subtractiveIndex);
                }
            }

            if (fileContent.size() - 1 > fileObjectRepresentativeList.size()) {
                System.out.println("Not all file data could be processed, please check your input.");
            }
        } else {
            System.out.println("A column name does not exist in your file, please check your input.");
        }
    }

    /**
     * Process the weather files content to a list of Weather objects.
     *
     * @param fileContent file content as a list of objects
     */
    public void processWeatherData(List<List<String>> fileContent) {
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

    /**
     * Checks whether a column exists.
     *
     * @param row    file row content as list
     * @param column name of column to be checked
     * @return true in case of existence
     */
    public boolean columnExists(List<String> row, String column) {
        return row.indexOf(column) != -1;
    }

    /**
     * Generates an object representative for a given file row.
     *
     * @param data             file row content as list
     * @param outputIndex      index of column which should be returned as result
     * @param minuendIndex     index of the first column for absolute difference calculation
     * @param subtractiveIndex index of the second column for absolute difference calculation
     */
    public void generateFileObjectRepresentative(List<String> data, int outputIndex, int minuendIndex, int subtractiveIndex) {
        String outputValue = data.get(outputIndex);
        int minuendValue, subtractiveValue;
        try {
            minuendValue = Integer.parseInt(data.get(minuendIndex));
            subtractiveValue = Integer.parseInt(data.get(subtractiveIndex));
            fileObjectRepresentativeList.add(new FileObjectRepresentative(outputValue, minuendValue, subtractiveValue));
        } catch (NumberFormatException e) {
            System.out.println("The file contained a non number format, please check your file.");
        }
    }
}
