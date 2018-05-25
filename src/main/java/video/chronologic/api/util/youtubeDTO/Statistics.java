package video.chronologic.api.util.youtubeDTO;

public class Statistics {
    private long favoriteCount;

    private long dislikeCount;

    private long likeCount;

    private long commentCount;

    private long viewCount;

    public long getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(long favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public long getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(long dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    public long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(long likeCount) {
        this.likeCount = likeCount;
    }

    public long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(long commentCount) {
        this.commentCount = commentCount;
    }

    public long getViewCount() {
        return viewCount;
    }

    public void setViewCount(long viewCount) {
        this.viewCount = viewCount;
    }

    @Override
    public String toString() {
        return "ClassPojo [favoriteCount = " + favoriteCount + ", dislikeCount = " + dislikeCount + ", likeCount = " + likeCount + ", commentCount = " + commentCount + ", viewCount = " + viewCount + "]";
    }
}
