package video.chronologic.api.dto;

import java.util.List;

public class SubRequest {
    private List<String> channelUrls;

    public List<String> getChannelUrls() {
        return channelUrls;
    }

    public void setChannelUrls(List<String> channelUrls) {
        this.channelUrls = channelUrls;
    }
}
