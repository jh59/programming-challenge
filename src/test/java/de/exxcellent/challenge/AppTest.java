package de.exxcellent.challenge;

import de.exxcellent.challenge.reader.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example JUnit 5 test case.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
class AppTest {

    private String successLabel = "not successful";
    private CSVReader csvReader;
    private String pathOfExistingFile = "src/main/resources/de/exxcellent/challenge/weather.csv";

    @BeforeEach
    void setUp() {
        successLabel = "successful";
        csvReader = new CSVReader();
    }

    @Test
    void aPointlessTest() {
        assertEquals("successful", successLabel, "My expectations were not met");
    }

    @Test
    void runFootball() {
        App.main("--football", "football.csv");
    }


    // Tests for reader component.

    @Test
    void checkReadFileByComparingFirstRow() {
        assertEquals(Arrays.asList("Day", "MxT", "MnT", "AvT", "AvDP", "1HrP TPcpn", "PDir", "AvSp", "Dir", "MxS", "SkyC", "MxR", "Mn", "R AvSLP"), csvReader.readFile(pathOfExistingFile).get(0));
    }

    @Test
    void checkFileIsValidForValidContent() {
        List<List<String>> validFileContent = new ArrayList<>();

        validFileContent.add(Arrays.asList("Day", "MxT", "MnT"));
        validFileContent.add(Arrays.asList("1", "30", "20"));

        Assertions.assertTrue(csvReader.fileIsValid(validFileContent));
    }

    @Test
    void checkFileIsValidForInvalidContent() {
        List<List<String>> invalidFileContent = new ArrayList<>();

        invalidFileContent.add(Arrays.asList("Day", "MxT", "MnT"));
        invalidFileContent.add(Arrays.asList("1", "30"));

        Assertions.assertFalse(csvReader.fileIsValid(invalidFileContent));
    }
}