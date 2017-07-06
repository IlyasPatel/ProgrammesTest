package uk.co.qa.service;

import enums.NumberOfDays;
import programmes.dao.ProgrammesDao;
import uk.co.qa.domain.ScheduleWindow;
import uk.co.qa.schedule.ScheduleService;
import uk.co.qa.domain.Programme;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.time.temporal.ChronoUnit.DAYS;

public class BbcProgrammeService {

    private ProgrammesDao programmesDao;
    private ScheduleService scheduleService;
    private Clock clock;

    public BbcProgrammeService(ProgrammesDao programmesDao, ScheduleService scheduleService, Clock clock) {
        this.programmesDao = programmesDao;
        this.scheduleService = scheduleService;
        this.clock = clock;
    }

    public Programme find(long programmeId) {

        Programme programme = programmesDao.find(programmeId);

        if (programme == null) {
            throw new IllegalArgumentException("Invalid Programme Id: " + programmeId);
        }

        return programme;
    }

    public Map<Long, ScheduleWindow> findProgrammesScheduled(NumberOfDays numberOfDays) {

        Map<Long, ScheduleWindow> programmesSchedule = new HashMap();

        Set<Long> allProgrammes = programmesDao.findAll();
        Map<Long, ScheduleWindow> programmesScheduled = scheduleService.getSchedule(allProgrammes);

        for (long id : programmesScheduled.keySet()) {
            ScheduleWindow scheduleWindow = programmesScheduled.get(id);
            long dateDiff = getDateDiff(clock.instant(), scheduleWindow.from());

            if (dateDiff >= 0 && dateDiff < numberOfDays.getNumberOfDays()) {
                programmesSchedule.put(id, scheduleWindow);
            }
        }

        return programmesSchedule;
    }

    private long getDateDiff(Instant date1, Date date2) {
        return DAYS.between(date1, date2.toInstant());
    }
}
