package com.example.wz1.lib;

import com.example.wz1.lib.util.MD5Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AccessApp {
    private final static String baseUrl = "http://mailp.bhome.com.cn:8896/";

    private final static String webUrl = "bhomeApi/MailSSO";

    private static String mDataformat = "yyyy-mm-dd hh:MM:ss";

    private String mUsername;
    private String appointKey;
    private String mVerify;
    private String currentTime;

    private AccessApp(Build build) {
        this.mUsername = build.mUsername;
        this.appointKey = build.appointKey;
        this.mVerify = build.mVerify;
        this.currentTime = build.currentTime;
    }




    public static class Build {

        private String mUsername;
        private String appointKey ="BhomeMail2018";
        private String mVerify;
        private String currentTime;

        public Build Username(String mUsername) {
            this.mUsername = mUsername;
            return this;
        }

        public Build appointKey(String appointKey) {
            this.appointKey = appointKey;
            return this;
        }

        public AccessApp build() {
            this.currentTime = getCurrentTime();
            this.mVerify = getVerify();
            return new AccessApp(this);
        }

        public String getVerify() {
            final StringBuffer stringBuffer = new StringBuffer(mUsername);
            final StringBuffer append = stringBuffer.append(currentTime).append(appointKey);
            final String result = append.toString();
            return MD5Util.MD5(result);
        }


        public static String getCurrentTime() {
            final SimpleDateFormat sdf = new SimpleDateFormat(mDataformat);
            final String format = sdf.format(new Date());
            return format;
        }

    }
}
