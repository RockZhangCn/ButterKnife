package test.mobile.richhr.com.butterknife;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity
{
    @BindView(R.id.toolbar)
    Toolbar toolbar;


    @BindView(R.id.text1)
    TextView textView1;

    @BindView(R.id.text2)
    TextView textView2;

    @BindView(R.id.fab)
    FloatingActionButton fab;


    @BindView(R.id.action)
    Button action;

    @BindView(R.id.show3dmap)
    Button action1;

    @BindView(R.id.show2dmap)
    Button action3;

    @BindView(R.id.action4)
    Button action4;

    @BindView(R.id.action5)
    Button action5;

    @BindView(R.id.action6)
    Button action6;

    @BindView(R.id.action7)
    Button action7;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textView1.setText("");
    }

    @Override
    public void overridePendingTransition(int enterAnim, int exitAnim)
    {
        super.overridePendingTransition(enterAnim, exitAnim);
    }

    private static long BEI_JING_STD_TIME_STAMP = 0;

    public void getBeiJinTime()
    {
        new AsyncTask<Void, Void, Long>()
        {
            @Override
            protected Long doInBackground(Void... params)
            {
                long ld = 0;
                try
                {
                    SntpClient client = new SntpClient();

                    if (client.requestTime("cn.pool.ntp.org", 50000))
                    {
                        ld = client.getNtpTime();
                    }
                }
                catch (Exception e)
                {
                    return 0L;
                }

                return ld / 1000;
            }

            @Override
            protected void onPostExecute(Long result)
            {
                BEI_JING_STD_TIME_STAMP = result;
                Date date = new Date(result * 1000);
                textView1.setText("times is " + result + " " + date);
            }
        }.execute();
    }

    private void rxJavaStudy()
    {
        Observable.create(new Observable.OnSubscribe<Long>()
        {
            @Override
            public void call(Subscriber<? super Long> subscriber)
            {
                long ld = 0;
                try
                {
                    SntpClient client = new SntpClient();
                    if (client.requestTime("cn.pool.ntp.org", 5000))
                    {
                        ld = client.getNtpTime();
                        subscriber.onNext(ld);
                    }
                    else
                    {
                        subscriber.onError(new Exception("get time failed return"));
                    }

                }
                catch (Exception e)
                {
                    subscriber.onError(new Exception("get time failed exception"));
                }

            }
        }).map(new Func1<Long, Date>()
        {
            @Override
            public Date call(Long aLong)
            {
                return new Date(aLong);
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Date>()
                {
                    @Override
                    public void call(Date date)
                    {
                        textView1.setText("times is " + date);
                    }
                }, new Action1<Throwable>()
                {
                    @Override
                    public void call(Throwable throwable)
                    {
                        textView1.setText(throwable.toString());
                    }
                });

//        Observable<String> myObservable = Observable.create(
//                new Observable.OnSubscribe<String>()
//                {
//                    @Override
//                    public void call(Subscriber<? super String> subscriber)
//                    {
//                        subscriber.onNext("Hello1");
//                        subscriber.onNext("Hello2");
//                        subscriber.onCompleted();
//                    }
//                }
//        );
        /*
        String array[] = {"1", "2", "3", "4", "88"};
        Observable.from(array)
                .flatMap(new Func1<String, Observable<String>>()
                {
                    @Override
                    public Observable<String> call(String s)
                    {
                        return Observable.just(s);
                    }
                })
                .map(new Func1<String, Integer>()
                {
                    @Override
                    public Integer call(String s)
                    {
                        return Integer.parseInt(s);
                    }
                })
//                .map(new Func1<Integer, String>()
//                {
//                    @Override
//                    public String call(Integer integer)
//                    {
//                        return String.valueOf(integer) + "pos";
//                    }
//                })
                .subscribe(new Action1<Integer>()
                {
                    @Override
                    public void call(Integer s)
                    {
                        numberCnt += s;
                        textView1.setText(String.valueOf(numberCnt));
                        //textView1.setText(s);
                    }
                });

//        Observable<String> myObservable = Observable.just("hello1", "hello2", "Hello3");
//
//        myObservable.subscribe(onNextAction);
            */
    }

    private int numberCnt = 0;

    Action1<String> onNextAction = new Action1<String>()
    {
        @Override
        public void call(String s)
        {
            textView1.setText(textView1.getText() + " + " + s);
        }
    };

    Subscriber<String> mySubscriber = new Subscriber<String>()
    {
        @Override
        public void onCompleted()
        {
            textView2.setText("completed");
        }

        @Override
        public void onError(Throwable e)
        {

        }

        @Override
        public void onNext(String s)
        {
            textView1.setText(textView1.getText() + " + " + s);
        }
    };

    @OnClick({R.id.action, R.id.fab, R.id.show3dmap, R.id.action2, R.id.show2dmap, R.id.action4, R.id.action5, R.id.action6, R.id.action7})
    public void buttonClick(View view)
    {
        int id = view.getId();
        switch (id)
        {
            case R.id.fab:
                //getSupportActionBar().show();
                rxJavaStudy();

                break;
            case R.id.action0:

                break;
            case R.id.show3dmap:
                startActivity(new Intent(MainActivity.this, Map3DActivity.class));
                break;
            case R.id.action2:
//                getSupportActionBar().hide();
                break;

            case R.id.show2dmap:
                StartMapActivity();
//                toolbar.setNavigationIcon(R.mipmap.ic_launcher);
                break;

            case R.id.action4:
                //getSupportActionBar().setLogo(R.mipmap.ic_launcher);
                Intent intent2 = new Intent(MainActivity.this, SecondActivity.class);

                startActivity(intent2);
                overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out);

                break;

            case R.id.action5:
                getBeiJinTime();
                break;

            case R.id.action6:
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                startActivity(intent);
                overridePendingTransition(R.anim.hold, R.anim.zoom_in_exit);
                break;

            case R.id.action7:
                Intent intent1 = new Intent(MainActivity.this, SecondActivity.class);

                startActivity(intent1);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;

            default:
                break;
        }

        // Toast.makeText(this, "Button is clicked." + id, Toast.LENGTH_SHORT).show();
    }

    private void StartMapActivity()
    {
        Intent intent = new Intent(MainActivity.this, MapActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
