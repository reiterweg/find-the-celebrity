package com.reiterweg.findthecelebrity.controller;

import com.reiterweg.findthecelebrity.domain.Attendance;
import com.reiterweg.findthecelebrity.factory.AttendanceFactory;
import com.reiterweg.findthecelebrity.service.AttendanceService;
import com.reiterweg.findthecelebrity.service.AttendanceServiceImpl;

public class AttendanceController {

    AttendanceService attendanceService = new AttendanceServiceImpl();

    public int execute() {
        Attendance attendance = new AttendanceFactory().getAttendance();
        return attendanceService.findTheCelebrity(attendance);
    }

}
