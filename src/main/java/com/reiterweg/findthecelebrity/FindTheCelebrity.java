package com.reiterweg.findthecelebrity;

import com.reiterweg.findthecelebrity.controller.AttendanceController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindTheCelebrity {

    private static final Logger logger = LoggerFactory.getLogger(FindTheCelebrity.class);

    public static void main(String[] args) {
        int celebrity = new AttendanceController().execute();

        if (celebrity >= 0) {
            logger.info("Celebrity at the party is person {}", celebrity);
        } else {
            logger.info("There is no celebrity at the party");
        }
    }

}
