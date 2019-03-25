package com.fta.skr.testbsdiff;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.fta.skr.testbsdiff.cpp.BsPatch;
import com.fta.skr.testbsdiff.utils.Const;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = Const.TAG;

    private TextView showText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showText = ((TextView) findViewById(R.id.sample_text));
        showText.setText(BuildConfig.VERSION_NAME);

    }

    public void handleBatch(View view) {
        doBspatch();
    }

    private void doBspatch() {
        final File destApk = new File(Environment.getExternalStorageDirectory(), "dest.apk");
        final File patch = new File(Environment.getExternalStorageDirectory(), "PATCH.patch");

        Log.e(TAG, "patch = " + patch.exists() + " , " + patch.getAbsolutePath());

        BsPatch.bspatch(ApkExtract.extract(this),
                destApk.getAbsolutePath(),
                patch.getAbsolutePath());

        Log.i(TAG, new File(Environment.getExternalStorageDirectory(), "old").getAbsolutePath() + " , " + destApk.exists());

        if (destApk.exists())
            ApkExtract.install(this, destApk);
    }
}
