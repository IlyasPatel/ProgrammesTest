package uk.co.qa.schedule;

import java.util.Date;

public class ScheduleWindow {

    private final Date from;
    private final Date to;

    public ScheduleWindow(Date from, Date to) {

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
