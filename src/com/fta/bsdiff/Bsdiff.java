package com.fta.bsdiff;

public class Bsdiff {

    public native static int diff(String oldFile, String newFile, String patchch);

    public native static int add(int a, int b);

}
