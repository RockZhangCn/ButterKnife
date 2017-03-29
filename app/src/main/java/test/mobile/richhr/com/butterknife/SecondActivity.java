package test.mobile.richhr.com.butterknife;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

/**
 * Created by rock on 17-3-22.
 */

public class SecondActivity extends AppCompatActivity
{
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.text)
    TextView textView;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.sec_action0)
    Button button0;

    @BindView(R.id.sec_action1)
    Button button1;

    @BindView(R.id.sec_action2)
    Button button2;

    @BindView(R.id.image)
    ImageView imageView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        middleButtonClick();
    }

    @OnClick(R.id.fab)
    protected void fabClick()
    {
        startActivity(new Intent(SecondActivity.this, Map3DActivity.class));
    }

    @OnClick(R.id.sec_action0)
    protected void topButtonClick()
    {
        //打开注册页面
        RegisterPage registerPage = new RegisterPage();
        registerPage.setRegisterCallback(new EventHandler()
        {
            public void afterEvent(int event, int result, Object data)
            {
                // 解析注册结果
                if (result == SMSSDK.RESULT_COMPLETE)
                {
                    @SuppressWarnings("unchecked")
                    HashMap<String, Object> phoneMap = (HashMap<String, Object>) data;
                    String country = (String) phoneMap.get("country");
                    String phone = (String) phoneMap.get("phone");

                    // 提交用户信息（此方法可以不调用）
                    //registerUser(country, phone);
                }
            }
        });

        registerPage.show(this);
    }


    @OnClick(R.id.sec_action1)
    protected void middleButtonClick()
    {
        Glide.with(this).
                load("http://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg").diskCacheStrategy(
                DiskCacheStrategy.ALL).into(imageView);

    }
}
