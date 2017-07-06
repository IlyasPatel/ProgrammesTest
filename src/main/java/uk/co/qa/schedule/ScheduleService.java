package uk.co.qa.schedule;

import uk.co.qa.domain.ScheduleWindow;

import java.util.Map;
import java.util.Set;

public interface ScheduleService {

    Map<Integer, ScheduleWindow> getSchedule(Set<Integer> allProgrammes) ;

}
