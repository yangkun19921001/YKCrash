package com.devyk.crash_module;

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

    static {
        System.loadLibrary("breakpad-core");
    }

    public static void initCrash(String path) {
        initBreakpadNative(path);
    }

    private static native void initBreakpadNative(String path);
}
