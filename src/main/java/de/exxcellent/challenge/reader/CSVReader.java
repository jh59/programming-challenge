package de.exxcellent.challenge.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Reads .csv files.
 *
 * @author Jessica Hohn
 */
public class CSVReader implements FileReaderComponent {

    /**
     * Reads a .csv file and returns its content.
     * @param filePath the file path
     * @return the files content as list
     */
    @Override
    public List<List<String>> readFile(String filePath) {
        List<List<String>> fileContent = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = br.readLine()) != null){
                String[] columnValues = line.split(",");
                fileContent.add(Arrays.asList(columnValues));
            }
        } catch (IOException e) {
            System.out.println("Invalid or non existent file.");
        }
        if(!fileIsValid(fileContent)){
            System.out.println("The file is not valid");
            return null;
        }
        return fileContent;
    }

    /**
     * Validate .csv file that each row has the same amount of columns.
     * @param fileContent the .csv content as list
     * @return true when the amount is always the same
     */
    @Override
    public boolean fileIsValid(List<List<String>> fileContent) {
        int amountOfColumns = fileContent.get(0).size();
        for (List<String> row:
             fileContent) {
            if(amountOfColumns != row.size()){
                return false;
            }
        }
        return true;
    }
}
