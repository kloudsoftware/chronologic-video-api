package video.chronologic.api.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Video")
public class Video {
    private String videoUrl;
    private String channelUrl;
    private String title;
    private String channelName;
    private long likeCount;
    private long dislikeCount;
    private long viewCount;
    private String description;
    private String thumbnailUrlSmall;
    private String thumbnailUrlMedium;
    private String thumbnailUrlLarge;
    private String thumbnailUrlMaxRes;

    @Id
    private String uri;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(long likeCount) {
        this.likeCount = likeCount;
    }

    public long getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(long dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    public long getViewCount() {
        return viewCount;
    }

    public void setViewCount(long viewCount) {
        this.viewCount = viewCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnailUrlSmall() {
        return thumbnailUrlSmall;
    }

    public void setThumbnailUrlSmall(String thumbnailUrlSmall) {
        this.thumbnailUrlSmall = thumbnailUrlSmall;
    }

    public String getThumbnailUrlMedium() {
        return thumbnailUrlMedium;
    }

    public void setThumbnailUrlMedium(String thumbnailUrlMedium) {
        this.thumbnailUrlMedium = thumbnailUrlMedium;
    }

    public String getThumbnailUrlLarge() {
        return thumbnailUrlLarge;
    }

    public void setThumbnailUrlLarge(String thumbnailUrlLarge) {
        this.thumbnailUrlLarge = thumbnailUrlLarge;
    }

    public String getThumbnailUrlMaxRes() {
        return thumbnailUrlMaxRes;
    }

    public void setThumbnailUrlMaxRes(String thumbnailUrlMaxRes) {
        this.thumbnailUrlMaxRes = thumbnailUrlMaxRes;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChannelUrl() {
        return channelUrl;
    }

    public void setChannelUrl(String channelUrl) {
        this.channelUrl = channelUrl;
    }
}
