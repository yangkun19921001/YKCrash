package com.devyk.crash_module;

import android.content.Context;
import android.text.TextUtils;

import com.devyk.crash_module.inter.ICrash;
import com.devyk.crash_module.inter.JavaCrashUtils;
import com.devyk.crash_module.inter.NativeCrashImp;

import java.io.File;

/**
 * <pre>
 *     author  : devyk on 2019-09-17 00:34
 *     blog    : https://juejin.im/user/578259398ac2470061f3a3fb/posts
 *     github  : https://github.com/yangkun19921001
 *     mailbox : yang1001yk@gmail.com
 *     desc    : This is Crash
 * </pre>
 */
public class Crash {


    /**
     * native 崩溃实现
     */
    private ICrash nativeCrashImp = new NativeCrashImp();

    /**
     * 上下文
     */
    private Context context = null;


    /**
     * native 崩溃日志
     */
    private void initNativeCrash(Context context, String nativePath) {
        if (!TextUtils.isEmpty(nativePath) &&
                new File(nativePath).exists())
            nativeCrashImp.init(context, nativePath);
    }

    private void initJavaCrash(Context context, String javaPath, JavaCrashUtils.OnCrashListener onCrashListener) {
        if (context != null &&
                !TextUtils.isEmpty(javaPath) &&
                new File(javaPath).exists() &&
                onCrashListener != null)
            JavaCrashUtils.getInstance().init(context, javaPath, onCrashListener);
    }


    public static class CrashBuild {
        private String javaCrashPath;
        private String nativeCrashPath;
        private Context context;
        private JavaCrashUtils.OnCrashListener onCrashListener;

        public CrashBuild(Context context) {
            this.context = context;
        }

        public CrashBuild javaCrashPath(String path, JavaCrashUtils.OnCrashListener onCrashListener) {
            this.javaCrashPath = path;
            this.onCrashListener = onCrashListener;
            return this;
        }

        public CrashBuild nativeCrashPath(String path) {
            this.nativeCrashPath = path;
            return this;
        }

        public void build() {
            Crash crash = new Crash();
            crash.context = this.context;
            crash.initNativeCrash(this.context, nativeCrashPath);
            crash.initJavaCrash(this.context, this.javaCrashPath, this.onCrashListener);
        }
    }


}
