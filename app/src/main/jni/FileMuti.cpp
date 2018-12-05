//
// Created by Administrator on 2018-12-03.
//

#include <jni.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "com_example_wz1_rxjava2_ndk_NDKFileUtil.h"
#include <android/log.h>

#define LOG_I(format,...)  __android_log_print(ANDROID_LOG_INFO,"filemuti",format,__VA_ARGS__);
#define LOG_E(format,...)  __android_log_print(ANDROID_LOG_ERROR,"filemuti",format,__VA_ARGS__);

//文件大小
long getFileSize(char* path) {

    FILE *pFILE = fopen(path, "rb");
    fseek(pFILE,0,SEEK_END);
    return ftell(pFILE);
}

//分割文件的方法 得到 路径，和 分包的路径


JNIEXPORT void JNICALL Java_com_example_wz1_rxjava2_ndk_NDKFileUtil_diff
(JNIEnv * env, jclass jobj, jstring opath, jstring  ppath, jint count){

    const char *orgchars = (*env).GetStringUTFChars(opath, NULL);
    const char *opathChars = (*env).GetStringUTFChars(ppath, NULL);

    char **pVoid = static_cast<char **>(malloc(sizeof(char *) * count));

    int i=0;
    for ( ;i  < count; i++) {
        pVoid[i]= static_cast<char *>(malloc(sizeof(char) * 100));
        sprintf(pVoid[i],opathChars,(i+1));
        LOG_I("path path %s",pVoid[i]);
    }

    long fileSize = getFileSize(const_cast<char *>(orgchars));
    FILE *orgFile = fopen(orgchars, "rb");

    if (fileSize % count ==0)
    {
        long size = fileSize / count;
        int i=0;
        for ( ; i < count;i ++) {
            FILE *pFILE = fopen(pVoid[i], "wb");
            int j = 0;
            for (; j < size; ++j) {
                fputc(fgetc(orgFile),pFILE);
            }
            fclose(pFILE);
        }
    } else{
        long partsize = fileSize / (count - 1);
        long lastSize = fileSize - (partsize * (count - 1));
        int i = 0;
        for (; i < count - 1; ++i) {
            FILE *wfile = fopen(pVoid[i], "wb");
            int j = 0;
            for (; j < partsize; ++j) {
                fputc(fgetc(orgFile),wfile);
            }
            fclose(wfile);
        }
        FILE *lastWFile = fopen(pVoid[count - 1], "wb");
        int n = 0;
        for (; n < lastSize; ++n) {
            fputc(fgetc(orgFile),lastWFile);
        }
        fclose(lastWFile);
    }

    fclose(orgFile);

    int y = 0;
    for (; y < count; ++y) {
       free(pVoid[y]);
    }

    free(pVoid);
    (*env).ReleaseStringUTFChars(opath,orgchars);
    (*env).ReleaseStringUTFChars(ppath,opathChars);
}

/*
 * Class:     com_example_wz1_rxjava2_ndk_NDKFileUtil
 * Method:    patch
 * Signature: (Ljava/lang/String;Ljava/lang/String;I)V
 */
JNIEXPORT void JNICALL Java_com_example_wz1_rxjava2_ndk_NDKFileUtil_patch
(JNIEnv * env, jclass jobj, jstring opath, jstring  ppath, jint count){
    const char *opathChar = (*env).GetStringUTFChars(opath,NULL);
    const char *ppatchChar = (*env).GetStringUTFChars(ppath, NULL);

    char destChar[100] ;
    strcpy(destChar,opathChar);
    strcat(destChar,"wuzeng.mp3");

    //destChar 原路径
    char **countP = static_cast<char **>(malloc(sizeof(char *) * count));

    FILE *wfile = fopen(destChar, "wb");
    int i = 1;
    for (; i < count; ++i) {
        countP[i] = static_cast<char *>(malloc(sizeof(char) * 100));
        sprintf(countP[i],ppatchChar,i);
        LOG_E("path %s",countP[i]);
        FILE *rfile = fopen(countP[i], "rb");
        long size = getFileSize(countP[i]);

        int j = 0;
        for (; j < size; ++j) {
            fputc(fgetc(rfile),wfile);
        }

        fclose(rfile);
    }
    fclose(wfile);

    int j = 1;
    for (; j < count; ++j) {
        free(countP[j]);
    }
    free(countP);

    (*env).ReleaseStringUTFChars(opath,opathChar);
    (*env).ReleaseStringUTFChars(ppath,ppatchChar);
}