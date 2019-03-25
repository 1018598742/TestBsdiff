package com.fta.skr.testbsdiff;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;
import android.util.Log;

import com.fta.skr.testbsdiff.utils.Const;

import java.io.File;

public class ApkExtract {

    private static final String TAG = Const.TAG;


    public static String extract(Context context) {
        context = context.getApplicationContext();
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String apkPath = applicationInfo.sourceDir;
        Log.i(TAG, "ApkExtract-extract: " + apkPath);
        return apkPath;
    }

    public static void install(Context context, String apkPath) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.setDataAndType(Uri.fromFile(new File(apkPath)),
                "application/vnd.android.package-archive");
        context.startActivity(i);
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    public static void install(Context context, File apkFile) {

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.setDataAndType(FileProvider.getUriForFile(context, context.getPackageName() + ".fp", apkFile), "application/vnd.android.package-archive");
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        } else {
            intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
        }
        context.startActivity(intent);
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
