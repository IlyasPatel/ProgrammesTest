package uk.co.qa.schedule;

import uk.co.qa.domain.ScheduleWindow;

import java.util.Map;
import java.util.Set;

public interface ScheduleService {

    /**
     * Get's a map of schedules for the provided programme Ids
     * @param programmeIds
     * @return Programme id and schedule
     */
    Map<Integer, ScheduleWindow> getSchedule(Set<Integer> programmeIds) ;

}
