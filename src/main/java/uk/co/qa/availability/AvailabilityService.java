package uk.co.qa.availability;

import java.util.Map;
import java.util.Set;

public interface AvailabilityService {

    Map<Long, AvailabilityWindow> getAvailability(Set<Long> allProgrammes) ;

}
