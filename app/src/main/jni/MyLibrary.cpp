//
// Created by Administrator on 2018-12-03.
//
#include "com_example_wz1_rxjava2_ndk_MyNdk.h"

JNIEXPORT jstring JNICALL Java_com_example_wz1_rxjava2_ndk_MyNdk_getStringFromC
        (JNIEnv * env, jclass jobj){
    return (*env).NewStringUTF("jiushiganC");
}
