package com.reiterweg.findthecelebrity.factory;

import com.reiterweg.findthecelebrity.domain.Attendance;

public class AttendanceFactory {

    public Attendance getAttendance() {
        String filePath = System.getProperty("filePath");
        Boolean absolute = Boolean.valueOf(System.getProperty("absolute"));

        if (filePath != null && !"".equals(filePath)) {
            return new AttendanceFromFile(filePath, absolute);
        } else {
            return new AttendanceFromScanner();
        }
    }

}
