package test.mobile.richhr.com.butterknife.api;

/**
 * Created by rock on 17-3-24.
 */

public class UpdateBean
{
//    enum UpdateType
//    {
//        FORCE,
//        OPTION,
//        LATEST
//    }

    private int updatetype;
    private String updateversion;
    private String updateurl;


    public UpdateBean(int type, String name,  String url)
    {
        updatetype = type;
        updateversion = name;
        updateurl = url;
    }

    public int getUpdatetype()
    {
        return updatetype;
    }

    public void setUpdatetype(int updatetype)
    {
        this.updatetype = updatetype;
    }

    public String getUpdateversion()
    {
        return updateversion;
    }

    public void setUpdateversion(String updateversion)
    {
        this.updateversion = updateversion;
    }

    public String getUpdateurl()
    {
        return updateurl;
    }

    public void setUpdateurl(String updateurl)
    {
        this.updateurl = updateurl;
    }

    @Override
    public String toString()
    {
        return "UpdateBean{" +
                "updatetype=" + updatetype +
                ", updateversion='" + updateversion + '\'' +
                ", updateurl='" + updateurl + '\'' +
                '}';
    }
}
