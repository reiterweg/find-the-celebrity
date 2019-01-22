package com.reiterweg.findthecelebrity.domain;

public abstract class Attendance {

    protected abstract void loadPeople();

    public abstract int[][] getPeople();

}
