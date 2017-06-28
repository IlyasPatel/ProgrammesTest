package enums;

public enum NumberOfDays {

    THREE(3),
    SEVEN(7),
    FOURTEEN(14);

    private int numberOfDays;

    NumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }
}
