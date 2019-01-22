package com.reiterweg.findthecelebrity.service;

import com.reiterweg.findthecelebrity.domain.Attendance;

import java.util.Stack;

public class AttendanceServiceImpl implements AttendanceService {

    @Override
    public int findTheCelebrity(Attendance attendance) {
        Stack<Integer> stack = new Stack<>();
        int n = attendance.getPeople().length;

        if (n < 1) {
            return -1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (knows(attendance, i, j)) {
                    stack.push(j);
                }
            }
        }

        int first = -1;
        int second;

        while (!stack.isEmpty()) {
            first = stack.pop();

            if (stack.isEmpty()) {
                break;
            }

            second = stack.pop();
            if (knows(attendance, first, second)) {
                stack.push(second);
            } else {
                stack.push(first);
            }
        }

        return first;
    }

    private Boolean knows(Attendance attendance, int a, int b) {
        return attendance.getPeople()[a][b] == 1;
    }

}
