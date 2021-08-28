package de.exxcellent.challenge.processing;

/**
 * Weather represents the most important columns of the weather.csv.
 *
 * @author Jessica Hohn
 */
public class Weather implements Comparable {
    private int day;
    private int maxTemp;
    private int minTemp;
    private int tempSpread;

    public Weather(int day, int maxTemp, int minTemp) {
        this.day = day;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.tempSpread = Math.abs(maxTemp - minTemp);
    }

    public int getDay() {
        return day;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public int getTempSpread() {
        return tempSpread;
    }

    @Override
    public int compareTo(Object o) {
        Weather other = (Weather) o;
        if (this.tempSpread < other.tempSpread) {
            return -1;
        } else if (this.tempSpread == other.tempSpread) {
            return 0;
        } else {
            return 1;
        }
    }
}
