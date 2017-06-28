package uk.co.qa.availability;

import java.util.Date;

public class AvailabilityWindow {

    private final Date from;
    private final Date to;

    public AvailabilityWindow(Date from, Date to) {

        this.from = from;
        this.to = to;
    }

    public Date from() {
        return from;
    }

    public Date to() {
        return to;
    }

}
