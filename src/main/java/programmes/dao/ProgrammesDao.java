package programmes.dao;

import uk.co.qa.domain.Programme;

import java.util.Set;

public interface ProgrammesDao {
    Programme find(Long programmeId);

    Set<Long> findAll();
}
