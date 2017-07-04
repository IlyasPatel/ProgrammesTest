package uk.co.qa.schedule;

import java.util.Map;
import java.util.Set;

public interface ScheduleService {

    Map<Long, ScheduleWindow> getSchedule(Set<Long> allProgrammes) ;

}
