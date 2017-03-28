package test.mobile.richhr.com.butterknife.api;



import java.util.List;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;


/**
 * Created by long on 2016/8/22.
 * API 接口
 */
public interface IRecruitAPI
{
    @GET("ymzp/update")
    Observable<UpdateBean> getUpdateResponse(@Query("curversion") String curVersion);


}
