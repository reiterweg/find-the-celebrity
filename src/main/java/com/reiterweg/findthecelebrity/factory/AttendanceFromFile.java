package com.reiterweg.findthecelebrity.factory;

import com.reiterweg.findthecelebrity.domain.Attendance;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class AttendanceFromFile extends Attendance {

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
        BufferedReader reader = null;
        int numberOfPeople = 0;
        String line;

        try {
            reader = new BufferedReader(new FileReader(file));

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
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
