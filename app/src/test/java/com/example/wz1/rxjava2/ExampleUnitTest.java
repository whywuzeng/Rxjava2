package com.example.wz1.rxjava2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test111(){
//        final String s = MD5Util.MD5("zhangsan" + "2017-30-28 02:02:53" + "BhomeMail2018");
//        System.out.println(s);
    }

    @Test
    public void test12312(){
        final TestLruPoolStrategy strategy = new TestLruPoolStrategy();
         Bitmap bitmap = BitmapFactory.decodeFile("/mnt/sdcard/NewPic/agora_handup_disable.png");
        strategy.put(bitmap);
         bitmap = BitmapFactory.decodeFile("/mnt/sdcard/NewPic/agora_handup_on.png");
        strategy.put(bitmap);
         bitmap = BitmapFactory.decodeFile("/mnt/sdcard/NewPic/agora_handup_on_press.png");
        strategy.put(bitmap);
         bitmap = BitmapFactory.decodeFile("/mnt/sdcard/NewPic/app_btn_lucky_normal.png");
        strategy.put(bitmap);
         bitmap = BitmapFactory.decodeFile("/mnt/sdcard/NewPic/app_btn_lucky_press.png");
        strategy.put(bitmap);
         bitmap = BitmapFactory.decodeFile("/mnt/sdcard/NewPic/changeteam_tip_placeholder.png");
        strategy.put(bitmap);
         bitmap = BitmapFactory.decodeFile("/mnt/sdcard/NewPic/college_img_apartment_normal.png");
        strategy.put(bitmap);
         bitmap = BitmapFactory.decodeFile("/mnt/sdcard/NewPic/college_img_public_normal.png");
        strategy.put(bitmap);
         bitmap = BitmapFactory.decodeFile("/mnt/sdcard/NewPic/contacts_tip_phone.png");
        strategy.put(bitmap);
         bitmap = BitmapFactory.decodeFile("/mnt/sdcard/NewPic/dm_btn_document_normal.png");
        strategy.put(bitmap);
         bitmap = BitmapFactory.decodeFile("/mnt/sdcard/NewPic/dm_btn_document_press.png");
        strategy.put(bitmap);
         bitmap = BitmapFactory.decodeFile("/mnt/sdcard/NewPic/doc_tip_download_yp.png");
        strategy.put(bitmap);
         bitmap = BitmapFactory.decodeFile("/mnt/sdcard/NewPic/doc_tip_favorite_yp.png");
        strategy.put(bitmap);
         bitmap = BitmapFactory.decodeFile("/mnt/sdcard/NewPic/doc_tip_file.png");
        strategy.put(bitmap);
         bitmap = BitmapFactory.decodeFile("/mnt/sdcard/NewPic/doc_tip_upload_yp.png");
        strategy.put(bitmap);
         bitmap = BitmapFactory.decodeFile("/mnt/sdcard/NewPic/file_icon_img_voice.png");
        strategy.put(bitmap);
//        file_icon_normal_folder.png
//        file_icon_public_folder.png
//        file_icon_share_folder.png
//        file_icon_video_big.png
//        file_icon_zip_big_lock.png
//        ic_checkin_shortcut.png
//        ic_launcher_foreground.xml
//        inbox_btn_approval_normal.png
//        inbox_btn_call_normal.png
//        inbox_btn_call_press.png
//        inbox_btn_check_in_normal.png
//        inbox_btn_check_in_press.png
//        inbox_btn_document_normal.png
//        inbox_btn_document_yunpan.png
//        inbox_btn_picture_normal.png
//        inbox_btn_report_normal.png
//        inbox_btn_sign_normal.png
//        inbox_btn_sms_normal.png
//        inbox_btn_traceless_normal.png
//        inbox_btn_traceless_out_normal.png
//        inbox_btn_vote_normal.png
//        item_client_square.png
//        item_crm_client_dialog.png
//        menu_btn_addwai_normal.png
//        menu_btn_addwai_press.png
//        menu_btn_creategroup_normal.png
//        menu_btn_creategroup_press.png
//        menu_btn_invite_normal.png
//        menu_btn_invite_press.png
//        menu_btn_phone_normal.png
//        menu_btn_phone_press.png
//        menu_btn_scan_normal.png
//        menu_btn_scan_press.png
//        menu_btn_scan_zhibo_normal.png
//        menu_btn_scan_zhibo_press.png
//        menu_btn_scannamecard_normal.png
//        menu_btn_scannamecard_press.png
//        menu_btn_send_normal.png
//        menu_btn_send_press.png
//        menu_btn_session_normal.png
//        menu_btn_session_press.png
//        menu_btn_touping_normal.png
//        menu_btn_touping_press.png
//        menu_btn_zhuanxin_close_normal.png
//        menu_btn_zhuanxin_close_press.png
//        menu_btn_zhuanxin_open_normal.png
//        menu_btn_zhuanxin_open_press.png
//        message_rss.png
//        more_btn_cloud.png
//        more_btn_collection.png
//        more_btn_forward.png
//        more_btn_other.png
//        more_btn_pc.png
//        more_btn_wps.png
//        sign_btn_punchbutton_normal.png
//        sign_btn_punchbutton_press.png
//        status_list_activities_down.png
//        status_list_activities_normal.png
//        status_list_discuss_down.png
//        status_list_discuss_normal.png
//        status_list_follows_down.png
//        status_list_follows_nomal.png
//        status_list_notice_down.png
//        status_list_notice_normal.png
//        tab_btn_yunzhijia_focus.png
//        toolbar_btn_address_focus.png
//        toolbar_btn_address_normal.png
//        toolbar_btn_app_focus.png
//        toolbar_btn_app_normal.png
//        toolbar_btn_me_focus.png
//        toolbar_btn_me_normal.png
//        toolbar_btn_message_focus.png
//        toolbar_btn_message_normal.png
//        weight_btn_card_normal.png
//        weight_btn_card_press.png
//        weight_btn_conversation_normal.png
//        weight_btn_conversation_press.png
//        weight_btn_location_normal.png
//        weight_btn_location_press.png
//        weight_btn_message.png
//        weight_btn_message_normal.png
//        weight_btn_message_press.png
//        weight_btn_search_normal.png
//        weight_btn_search_press.png
//        weight_btn_sign_normal.png
//        weight_btn_sign_press.png
//        weight_btn_sweep_normal.png
//        weight_btn_sweep_press.png
//        weight_btn_todo_normal.png
//        weight_btn_todo_press.png

        System.out.println("12132");
    }



}