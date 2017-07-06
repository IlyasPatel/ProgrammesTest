package programmes.dao;

import uk.co.qa.domain.Programme;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class InMemoryProgrammesDao implements ProgrammesDao {

    private Map<Integer, Programme> programmes;

    public InMemoryProgrammesDao() {
        this.programmes = new HashMap<>();
    }

    public void addProgrammesToDatabase(Programme programme) {
        programmes.put(programme.getId(), programme);
    }

    @Override
    public Programme find(int programmeId) {
        return programmes.get(programmeId);
    }

    @Override
    public Set<Integer> findAll() {
        return programmes.keySet();
    }
}
