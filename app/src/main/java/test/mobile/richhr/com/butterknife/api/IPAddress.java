package test.mobile.richhr.com.butterknife.api;

/**
 * Created by rock on 17-3-24.
 */

public class IPAddress
{
    private String ip;


    IPAddress(String ipstr)
    {
        ip = ipstr;
    }

    public String getIp()
    {
        return ip;
    }

    public void setIp(String ipaddress)
    {
        this.ip = ipaddress;
    }


    public String toString()
    {
        return ip;
    }
}
