package test.mobile.richhr.com.butterknife.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import test.mobile.richhr.com.butterknife.R;

/**
 * Created by moon.zhong on 2015/2/26.
 */
public class DialogCreate
{

    public static void showRedTitleDialog(Context context, String title, String message, AlertDialog.OnClickListener listener)
    {
        DialogBuilder dialogBuilder = new DialogBuilder(context);
        dialogBuilder.setTitle(title);
        dialogBuilder.setMessage(message);
        dialogBuilder.setNegativeButton("确定", listener);
        dialogBuilder.setPositiveButton("取消", null);
        dialogBuilder.create();
        dialogBuilder.show();
    }

    public static void showWeChatTitleDialog(Context context)
    {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        dialogBuilder.create();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.wechat_dialog, null);
        dialogBuilder.setView(view);
        dialogBuilder.show();
    }
}
