package com.example.wz1.rxjava2.effect;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.wz1.rxjava2.R;

import org.fmod.FMOD;

import java.io.File;

/**
 * Created by Administrator on 2018-12-05.
 * <p>
 * by author wz
 * <p>
 * com.example.wz1.rxjava2.effect
 */
public class QQVoiceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FMOD.init(this);
        setContentView(R.layout.activity_qq_voice);


    }

    public void mFix(final View btn) {
        RxPermissions rxPermission = new RxPermissions(QQVoiceActivity.this);
        rxPermission.request(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.RECORD_AUDIO)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean granted) {
                        if (granted) {
                            String path = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "myvoice.wav";
                            //String path = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "drumloop.wav";
                            Log.d("QQVoiceActivity", path);
                            switch (btn.getId()) {
                                case R.id.btn_normal:
                                    EffectUtils.fix(path, EffectUtils.MODE_NORMAL);
                                    break;

                                case R.id.btn_luoli:
                                    EffectUtils.fix(path, EffectUtils.MODE_LUOLI);
                                    break;

                                case R.id.btn_dashu:
                                    EffectUtils.fix(path, EffectUtils.MODE_DASHU);
                                    break;

                                case R.id.btn_jingsong:
                                    EffectUtils.fix(path, EffectUtils.MODE_JINGSONG);
                                    break;

                                case R.id.btn_gaoguai:
                                    EffectUtils.fix(path, EffectUtils.MODE_GAOGUAI);
                                    break;

                                case R.id.btn_kongling:
                                    EffectUtils.fix(path, EffectUtils.MODE_KONGLING);
                                    break;

                                default:
                                    break;
                            }


                        }
                        else {
                            Toast.makeText(QQVoiceActivity.this, "权限被拒绝,请到设置中打开", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        FMOD.close();
    }
}
