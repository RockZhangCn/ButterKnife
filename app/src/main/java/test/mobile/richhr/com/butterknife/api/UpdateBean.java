package test.mobile.richhr.com.butterknife.api;

/**
 * Created by rock on 17-3-24.
 */

public class UpdateBean
{
    enum UpdateType
    {
        FORCE,
        OPTION,
        LATEST
    }

    private UpdateType updateType;
    private String updateBinUrl;

    public String getUpdateBinUrl()
    {
        return updateBinUrl;
    }

    public void setUpdateBinUrl(String updateBinUrl)
    {
        this.updateBinUrl = updateBinUrl;
    }

    public UpdateType getUpdateType()
    {
        return updateType;
    }

    public void setUpdateType(UpdateType updateType)
    {
        this.updateType = updateType;
    }

    public UpdateBean(UpdateType type, String url)
    {
        updateType = type;
        updateBinUrl = url;
    }
}
