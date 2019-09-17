package com.devyk.crash_module;

import android.content.Context;
import android.text.TextUtils;

import com.devyk.crash_module.inter.ICrash;
import com.devyk.crash_module.inter.JavaCrashImp;
import com.devyk.crash_module.inter.NativeCrashImp;

import java.io.File;

/**
 * <pre>
 *     author  : devyk on 2019-09-17 00:34
 *     blog    : https://juejin.im/user/578259398ac2470061f3a3fb/posts
 *     github  : https://github.com/yangkun19921001
 *     mailbox : yang1001yk@gmail.com
 *     desc    : This is CrashUtils
 * </pre>
 */
public class CrashUtils {

    /**
     * Java 层 崩溃实现
     */
    private static ICrash javaCrash = new JavaCrashImp();

    /**
     * native 崩溃实现
     */
    private static ICrash nativeCrashImp = new NativeCrashImp();

    /**
     * native 崩溃日志
     */
    public static void initNativeCrash(Context context, String nativePath) {
        if (!TextUtils.isEmpty(nativePath) || new File(nativePath).exists())
            nativeCrashImp.init(context, nativePath);
    }


}
