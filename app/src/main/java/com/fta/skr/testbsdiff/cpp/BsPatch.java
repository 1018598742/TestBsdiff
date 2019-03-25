package com.fta.skr.testbsdiff.cpp;

public class BsPatch {

    //     Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    public static native int bspatch(String oldApk, String newApk, String patch);

}

