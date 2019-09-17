package com.devyk.ykcrash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import com.devyk.crash_module.CrashUtils;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    static {
        System.loadLibrary("crash-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String nativePath = Environment.getExternalStorageDirectory() + "/T01/native/";
        File natPath = new File(nativePath);
        if (!natPath.exists())
            natPath.mkdirs();
        CrashUtils.initCrash(nativePath);

    }


    public native static void testCrash();

    public void nativeCrash(View view) {
        testCrash();
    }

    public void javaCrash(View view) {
        System.out.println(1 / 0);
    }
}
