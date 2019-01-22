package com.reiterweg.findthecelebrity;

import com.reiterweg.findthecelebrity.controller.AttendanceController;

public class FindTheCelebrity {

    public static void main(String[] args) {
        int celebrity = new AttendanceController().execute();

        if (celebrity >= 0) {
            System.out.printf("Celebrity at the party is person %d%n", celebrity);
        } else {
            System.out.println("There is no celebrity at the party");
        }
    }

}
