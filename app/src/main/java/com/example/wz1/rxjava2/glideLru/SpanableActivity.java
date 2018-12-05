package com.example.wz1.rxjava2.glideLru;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.wz1.rxjava2.R;
import com.example.wz1.rxjava2.ndk.MyNdk;
import com.example.wz1.rxjava2.ndk.NDKFileUtil;

import org.xml.sax.XMLReader;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2018-11-28.
 * <p>
 * by author wz
 * <p>
 * com.example.wz1.rxjava2.glideLru
 */
public class SpanableActivity extends AppCompatActivity {
    
    private static final String TAG = "SpanableActivity";
    private static int REQUEST_PERMISSION_CODE=0x4576;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spanable_layout);
        TextView textview = findViewById(R.id.textview);
        Button writeBtn = findViewById(R.id.btn_write);
        Button btn_path=findViewById(R.id.btn_path);
        String htmlStr = "<font style=\"color:#ff6c00;font-size:18px\"> 1500/天</font> <font style=\"TEXT-DECORATION: line-through;" +
                "color:#808080;font-size:10px\">原价:20000元 </font>";

        String htmlStr_1 = "<font color='#ff6c00' size='4'> 1500/天</font> <del><font  color='#808080' size='2'>原价:20000元 </font></del>";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textview.setText(Html.fromHtml(htmlStr_1, Html.FROM_HTML_MODE_COMPACT, null, new Html.TagHandler() {
                int startTag;
                int endTag;

                @Override
                public void handleTag(boolean opening, String tag, Editable output, XMLReader xmlReader) {
                    if (tag.equalsIgnoreCase("del"))
                    {
                        if (opening){
                            startTag= output.length();
                        }else {
                            endTag= output.length();
                            output.setSpan(new StrikethroughSpan(),startTag,endTag, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        }
                    }
                }
            }));
        }else {
            textview.setText(Html.fromHtml(htmlStr_1));
        }
// /storage/emulated/0
        final String stringFromC = MyNdk.getStringFromC();
        System.out.println(stringFromC);
        textview.setText(stringFromC);
        permissionsMethod();
        SDCardPath= Environment.getExternalStorageDirectory().getAbsolutePath();
        writeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mergePackage();
            }
        });

        btn_path.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diffPackage();
            }
        });
    }

    private String SDCardPath;

    /**
     * 拆包
     */
    public void diffPackage(){
        final String originPath = SDCardPath + File.separator + "小苹果.mp3";
        final File file = new File(originPath);
        if (file.exists()&&file.isFile())
        {
            Log.e(TAG, "diffPackage: "+file.getAbsolutePath()+":文件存在" );
        }else {
            Log.e(TAG, "diffPackage: "+file.getAbsolutePath()+":文件不存在" );
        }
        final String diffPackage = SDCardPath + File.separator + "小苹果%d.mp3";
        for (int i = 0;i<3;i++){
            final String format = String.format(diffPackage, i);
            genarateFile(format);
        }
        NDKFileUtil.diff(originPath,diffPackage,3);
        Log.e(TAG, "diffPackage: 进行拆分" );
    }

    public void mergePackage(){
        final String originPath = SDCardPath + File.separator + "小苹果.mp3";
        final File file = new File(originPath);
        if (file.exists()&&file.isFile())
        {
            Log.e(TAG, "diffPackage: "+file.getAbsolutePath()+":文件存在" );
        }else {
            Log.e(TAG, "diffPackage: "+file.getAbsolutePath()+":文件不存在" );
        }
        final String diffPackage = SDCardPath + File.separator + "小苹果%d.mp3";
        for (int i = 0;i<3;i++){
            final String format = String.format(diffPackage, i);
            genarateFile(format);
        }
        NDKFileUtil.patch(originPath,diffPackage,3);
        Log.e(TAG, "diffPackage: 进行拆分" );
    }

    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};

    public void permissionsMethod(){

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_PERMISSION_CODE);
            }
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_CODE) {
            for (int i = 0; i < permissions.length; i++) {
                Log.e("MainActivity", "申请的权限为：" + permissions[i] + ",申请结果：" + grantResults[i]);
            }
        }
    }


    private void genarateFile(String originPath) {
        final File orgfile = new File(originPath);
        if (null==orgfile||!orgfile.exists())
        {
            try {
                orgfile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 合并包
     */
    public void patchPackage(){
        final String originPath = SDCardPath + File.separator + "小苹果.mp3";
        final String diffPackage = SDCardPath + File.separator + "小苹果%d.mp3";
        NDKFileUtil.patch(originPath,diffPackage,3);
        Log.e(TAG, "diffPackage: 进行合并" );
    }

}
