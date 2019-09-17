#include <stdio.h>
#include <jni.h>


/**
 * 引起 crash
 */
void Crash() {
    volatile int *a = (int *) (NULL);
    *a = 1;
}

extern "C"
JNIEXPORT void JNICALL
Java_com_devyk_ykcrash_MainActivity_testCrash(JNIEnv *env, jclass type) {

    // TODO
    Crash();
}