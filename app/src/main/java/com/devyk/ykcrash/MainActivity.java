package com.devyk.ykcrash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import com.devyk.crash_module.Crash;
import com.devyk.crash_module.inter.JavaCrashUtils;

import java.io.File;

public class MainActivity extends AppCompatActivity implements JavaCrashUtils.OnCrashListener {
    static {
        System.loadLibrary("crash-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String nativePath = Environment.getExternalStorageDirectory() + "/CRASH/nativeCrash";
        File natPath = new File(nativePath);
        if (!natPath.exists())
            natPath.mkdirs();

        String javaPath = Environment.getExternalStorageDirectory() + "/CRASH/javaCrash";
        File javPath = new File(javaPath);
        if (!javPath.exists())
            javPath.mkdirs();

        //框架初始化
        new Crash.CrashBuild(getApplicationContext())
                .nativeCrashPath(nativePath)
                .javaCrashPath(javaPath, this)
                .build();

    }


    public native static void testCrash();

    public void nativeCrash(View view) {
        testCrash();
    }

    public void javaCrash(View view) {
        System.out.println(1 / 0);
    }

    @Override
    public void onCrash(String crashInfo, Throwable e) {
        Log.d("MainActivity", e.getMessage());
    }
}
