package de.exxcellent.challenge.processing;

/**
 * FileObjectRepresentative generalizes the .csv columns needed for the challenge.
 *
 * @author Jessica Hohn
 */
public class FileObjectRepresentative implements Comparable {
    private String outputValue;
    private int minuendValue;
    private int subtractiveValue;
    private int absoluteDifference;

    public FileObjectRepresentative(String outputValue, int minuendValue, int subtractiveValue) {
        this.outputValue = outputValue;
        this.minuendValue = minuendValue;
        this.subtractiveValue = subtractiveValue;
        this.absoluteDifference = Math.abs(minuendValue - subtractiveValue);
    }

    public String getOutputValue() {
        return outputValue;
    }

    public int getMinuendValue() {
        return minuendValue;
    }

    public int getSubtractiveValue() {
        return subtractiveValue;
    }

    public int getAbsoluteDifference() {
        return absoluteDifference;
    }

    @Override
    public int compareTo(Object o) {
        FileObjectRepresentative other = (FileObjectRepresentative) o;
        if (this.absoluteDifference < other.absoluteDifference) {
            return -1;
        } else if (this.absoluteDifference == other.absoluteDifference) {
            return 0;
        } else {
            return 1;
        }
    }
}
