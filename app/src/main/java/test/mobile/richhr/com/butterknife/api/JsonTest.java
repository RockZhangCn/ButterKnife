package test.mobile.richhr.com.butterknife.api;

/**
 * Created by rock on 17-3-24.
 */

public class JsonTest
{
    private String one;
    private String key;

    JsonTest(String name_, String value_)
    {
        one = name_;
        key = value_;
    }

    public String getOne()
    {
        return one;
    }

    public void setOne(String one)
    {
        this.one = one;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public String toString()
    {
        return one + " " + key ;
    }
}
