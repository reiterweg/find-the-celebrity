package com.reiterweg.findthecelebrity;

import com.reiterweg.findthecelebrity.factory.AttendanceFromFile;
import com.reiterweg.findthecelebrity.service.AttendanceService;
import com.reiterweg.findthecelebrity.service.AttendanceServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AttendanceTests {

    @Mock
    private AttendanceFromFile attendanceFromFile;

    private AttendanceService attendanceService;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        attendanceService = new AttendanceServiceImpl();
    }

    @Test
    public void withNoCelebrity() {
        int[][] people = new int[4][];
        people[0] = new int[]{0, 0, 0, 0};
        people[1] = new int[]{0, 0, 0, 0};
        people[2] = new int[]{0, 0, 0, 0};
        people[3] = new int[]{0, 0, 0, 0};

        when(attendanceFromFile.getPeople()).thenReturn(people);

        assertEquals(-1, attendanceService.findTheCelebrity(attendanceFromFile));
    }

    @Test
    public void withOneCelebrity() {
        int[][] people = new int[4][];
        people[0] = new int[]{0, 0, 1, 0};
        people[1] = new int[]{0, 0, 1, 0};
        people[2] = new int[]{0, 0, 0, 0};
        people[3] = new int[]{0, 0, 1, 0};

        when(attendanceFromFile.getPeople()).thenReturn(people);

        assertEquals(2, attendanceService.findTheCelebrity(attendanceFromFile));
    }

    @Test
    public void withOneCelebrityKnowsHimself() {
        int[][] people = new int[4][];
        people[0] = new int[]{0, 0, 0, 1};
        people[1] = new int[]{0, 0, 0, 1};
        people[2] = new int[]{0, 0, 0, 1};
        people[3] = new int[]{0, 0, 0, 1};

        when(attendanceFromFile.getPeople()).thenReturn(people);

        assertEquals(3, attendanceService.findTheCelebrity(attendanceFromFile));
    }

}
