package test.mobile.richhr.com.butterknife;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
    }

    @OnClick(R.id.fab)
    protected void fabClick()
    {
        startActivity(new Intent(SecondActivity.this, Map3DActivity.class));
    }
}
