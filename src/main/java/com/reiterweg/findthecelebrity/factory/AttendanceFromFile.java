package com.reiterweg.findthecelebrity.factory;

import com.reiterweg.findthecelebrity.domain.Attendance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class AttendanceFromFile extends Attendance {

    private static final Logger logger = LoggerFactory.getLogger(AttendanceFromFile.class);

    private int[][] people;
    private File file;

    public AttendanceFromFile(String filePath, Boolean absolute) {
        if (absolute) {
            file = new File(filePath);
        } else {
            file = new File(getClass().getClassLoader().getResource(filePath).getFile());
        }

        loadPeople();
    }

    @Override
    public int[][] getPeople() {
        return people;
    }

    @Override
    protected void loadPeople() {
        int numberOfPeople = 0;
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            if ((line = reader.readLine()) != null) {
                numberOfPeople = Integer.valueOf(line);
            }

            if (numberOfPeople != 0) {
                people = new int[numberOfPeople][numberOfPeople];

                for (int i = 0; i < numberOfPeople; i++) {
                    line = reader.readLine();
                    people[i] = Stream.of(line.split("\\s")).mapToInt(Integer::parseInt).toArray();
                }
            }
        } catch (IOException e) {
            logger.error("There was an error loading info file {}", file.getAbsolutePath(), e);
        }
    }

}
