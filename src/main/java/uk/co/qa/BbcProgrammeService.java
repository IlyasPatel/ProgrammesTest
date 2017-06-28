package uk.co.qa;

import enums.NumberOfDays;
import programmes.dao.ProgrammesDao;
import uk.co.qa.availability.AvailabilityService;
import uk.co.qa.availability.AvailabilityWindow;
import uk.co.qa.domain.Programme;

import java.time.Clock;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.time.temporal.ChronoUnit.DAYS;

public class BbcProgrammeService {

    private ProgrammesDao programmesDao;
    private AvailabilityService availabilityService;
    private Clock clock;

    public BbcProgrammeService(ProgrammesDao programmesDao, AvailabilityService availabilityService, Clock clock) {
        this.programmesDao = programmesDao;
        this.availabilityService = availabilityService;
        this.clock = clock;
    }

    public Programme find(long programmeId) {
        return programmesDao.find(programmeId);
    }

    public Map<Long, AvailabilityWindow> findProgrammesAvailableFor(NumberOfDays numberOfDays) {
        Map<Long, AvailabilityWindow> programmesAvailable = new HashMap();

        Set<Long> allProgrammes = programmesDao.findAll();
        Map<Long, AvailabilityWindow> programmeAvailability = availabilityService.getAvailability(allProgrammes);

        for (long id : programmeAvailability.keySet()) {
            AvailabilityWindow availabilityWindow = programmeAvailability.get(id);
            long dateDiff = getDateDiff(clock, availabilityWindow.to());

            if (Math.signum(dateDiff) > 0 && dateDiff <= numberOfDays.getNumberOfDays()) {
                programmesAvailable.put(id, availabilityWindow);
            }
        }

        return programmesAvailable;
    }

    private long getDateDiff(Clock date1, Date date2) {
        return DAYS.between(date1.systemUTC().instant(), date2.toInstant());
    }
}
