package test.mobile.richhr.com.butterknife.api;



import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


/**
 * Created by long on 2016/8/22.
 * API 接口
 */
public interface IJsonTestAPI
{
    @GET("key/value/one/two")
    Observable<JsonTest> getJsonTest();

    @GET("/")
    Observable<IPAddress> getIPAddress();
}
