package uk.co.qa.service;

import org.junit.Before;
import org.junit.Test;
import programmes.dao.InMemoryProgrammesDao;
import uk.co.qa.domain.Programme;
import uk.co.qa.domain.ScheduleWindow;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BbcProgrammeServiceITest {

    private BbcProgrammeService sut;
    private InMemoryProgrammesDao programmesDao;

    private final LocalDateTime REFERENCE_DATE_TIME = LocalDateTime.of(2017, 7, 3, 10, 0); //2017-04-03 at 10:00am
    private final ZoneId defaultZone = ZoneId.systemDefault();
    private final Clock FIXED_CLOCK = Clock.fixed(REFERENCE_DATE_TIME.atZone(defaultZone).toInstant(), defaultZone);

    @Before
    public void setUp() {

        Programme doctorWho = new Programme(1, "Doctor Who");
        Programme eastenders = new Programme(2, "Eastenders");
        Programme matchOfTheDay1 = new Programme(3, "Match of the Day 1");

        ScheduleWindow doctorWhoSW = new ScheduleWindow(getDate(2017, 7, 1), getDate(2017, 8, 1));
        ScheduleWindow eastendersSW = new ScheduleWindow(getDate(2017, 7, 2), getDate(2017, 8, 1));
        ScheduleWindow matchOfTheDaySW = new ScheduleWindow(getDate(2017, 7, 3), getDate(2016, 8, 1));

        programmesDao = new InMemoryProgrammesDao();
        programmesDao.addProgrammesToDatabase(doctorWho);
        programmesDao.addProgrammesToDatabase(eastenders);
        programmesDao.addProgrammesToDatabase(matchOfTheDay1);


        sut = new BbcProgrammeService(programmesDao, null, FIXED_CLOCK);
    }

    private Date getDate(int yyyy, int mm, int dd) {
        LocalDate localDate = LocalDate.of(yyyy,mm, dd);

        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    @Test
    public void when_i_search_for_a_programme_with_valid_id_then_programme_is_found() {

        Programme programme = sut.find(1);

        assertThat(programme.getId(), is(equalTo(1)));
        assertThat(programme.getName(), is(equalTo("Doctor Who")));
    }


}
