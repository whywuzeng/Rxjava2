package com.example.wz1.rxjava2.glideLru;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.example.wz1.rxjava2.R;

/**
 * Created by Administrator on 2018-11-28.
 * <p>
 * by author wz
 * <p>
 * com.example.wz1.rxjava2.glideLru
 *
 * /storage/emulated/0/NewPic/agora_handup_disable
 *
 * Environment.getExternalStorageDirectory().getPath()
 */
public class GlideLruActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_layout);
        ImageView img1 =findViewById(R.id.img1);
        ImageView img2 = findViewById(R.id.img2);
//        final TestLruPoolStrategy strategy = new TestLruPoolStrategy();

        MemorySizeCalculator calculator = new MemorySizeCalculator(this);
        int size = calculator.getBitmapPoolSize();
        LruBitmapPool strategy = new LruBitmapPool(size);



        final Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.agora_handup_disable);
        img1.setImageBitmap(bitmap);

        strategy.put(bitmap);
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.agora_handup_on));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.agora_handup_on_press));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.app_btn_lucky_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.app_btn_lucky_press));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.changeteam_tip_placeholder));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.college_img_apartment_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.college_img_public_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.contacts_tip_phone));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.dm_btn_document_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.dm_btn_document_press));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.doc_tip_download_yp));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.doc_tip_favorite_yp));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.doc_tip_file));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.doc_tip_upload_yp));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.file_icon_img_voice));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.file_icon_normal_folder));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.file_icon_public_folder));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.file_icon_share_folder));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.file_icon_video_big));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.file_icon_zip_big_lock));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.ic_checkin_shortcut));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.inbox_btn_approval_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.inbox_btn_call_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.inbox_btn_call_press));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.inbox_btn_check_in_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.inbox_btn_check_in_press));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.inbox_btn_document_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.inbox_btn_document_yunpan));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.inbox_btn_picture_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.inbox_btn_report_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.inbox_btn_sign_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.inbox_btn_sms_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.inbox_btn_traceless_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.inbox_btn_traceless_out_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.inbox_btn_vote_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.item_client_square));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.item_crm_client_dialog));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.menu_btn_addwai_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.menu_btn_addwai_press));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.menu_btn_creategroup_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.menu_btn_creategroup_press));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.menu_btn_invite_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.menu_btn_invite_press));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.menu_btn_phone_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.menu_btn_phone_press));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.menu_btn_scan_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.menu_btn_scan_press));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.menu_btn_scan_zhibo_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.menu_btn_scan_zhibo_press));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.menu_btn_scannamecard_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.menu_btn_scannamecard_press));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.menu_btn_send_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.menu_btn_send_press));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.menu_btn_session_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.menu_btn_session_press));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.menu_btn_touping_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.menu_btn_touping_press));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.menu_btn_zhuanxin_close_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.menu_btn_zhuanxin_close_press));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.menu_btn_zhuanxin_open_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.menu_btn_zhuanxin_open_press));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.message_rss));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.more_btn_cloud));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.more_btn_collection));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.more_btn_forward));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.more_btn_other));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.more_btn_pc));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.more_btn_wps));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.sign_btn_punchbutton_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.sign_btn_punchbutton_press));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.status_list_activities_down));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.status_list_activities_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.status_list_discuss_down));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.status_list_discuss_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.status_list_follows_down));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.status_list_follows_nomal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.status_list_notice_down));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.status_list_notice_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.tab_btn_yunzhijia_focus));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.toolbar_btn_address_focus));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.toolbar_btn_address_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.toolbar_btn_app_focus));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.toolbar_btn_app_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.toolbar_btn_me_focus));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.toolbar_btn_me_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.toolbar_btn_message_focus));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.toolbar_btn_message_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.webpage_error));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.weight_btn_card_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.weight_btn_card_press));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.weight_btn_conversation_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.weight_btn_conversation_press));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.weight_btn_location_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.weight_btn_location_press));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.weight_btn_message));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.weight_btn_message_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.weight_btn_message_press));
        final Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.weight_btn_search_normal);
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.weight_btn_search_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.weight_btn_search_press));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.weight_btn_sign_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.weight_btn_sign_press));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.weight_btn_sweep_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.weight_btn_sweep_press));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.weight_btn_todo_normal));
        strategy.put(BitmapFactory.decodeResource(getResources(),R.drawable.weight_btn_todo_press));


        img1.setImageBitmap(bitmap2);
//        strategy.put(bitmap);

        final Bitmap bitmap1 = strategy.get(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        img2.setImageBitmap(bitmap1);

        img2.setImageBitmap(strategy.get(bitmap2.getWidth(), bitmap2.getHeight(), bitmap2.getConfig()));

        System.out.println(strategy.toString());
    }
}
