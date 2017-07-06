package programmes.dao;

import uk.co.qa.domain.Programme;

import java.util.Set;

public interface ProgrammesDao {
    Programme find(int programmeId);

    Set<Integer> findAll();
}
