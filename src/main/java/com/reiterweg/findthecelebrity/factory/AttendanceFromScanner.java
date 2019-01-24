package com.reiterweg.findthecelebrity.factory;

import com.reiterweg.findthecelebrity.domain.Attendance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Stream;

public class AttendanceFromScanner extends Attendance {

    private static final Logger logger = LoggerFactory.getLogger(AttendanceFromScanner.class);

    private int[][] people;

    public AttendanceFromScanner() {
        super();
        loadPeople();
    }

    @Override
    public int[][] getPeople() {
        return people;
    }

    @Override
    protected void loadPeople() {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = 0;
        String line;

        do {
            logger.info("How many attendants are there?");
            try {
                numberOfPeople = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                logger.error("Invalid input. Try again, please.");
            }
        } while (numberOfPeople == 0);

        people = new int[numberOfPeople][numberOfPeople];

        for (int i = 0; i < numberOfPeople; i++) {
            line = scanner.nextLine();
            people[i] = Stream.of(line.split("\\s")).mapToInt(Integer::parseInt).toArray();
        }

        scanner.close();
    }

}
