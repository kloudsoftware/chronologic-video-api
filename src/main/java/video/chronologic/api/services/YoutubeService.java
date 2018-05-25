package video.chronologic.api.services;

import com.rometools.rome.feed.synd.SyndEntry;
import org.springframework.stereotype.Service;
import video.chronologic.api.dto.Video;
import video.chronologic.api.util.YoutubeAPI;
import video.chronologic.api.util.youtubeDTO.Snippet;
import video.chronologic.api.util.youtubeDTO.Statistics;
import video.chronologic.api.util.youtubeDTO.VideoData;

import java.io.IOException;

@Service
public class YoutubeService {

    private final YoutubeAPI youtubeAPI;

    public YoutubeService(YoutubeAPI youtubeAPI) {
        this.youtubeAPI = youtubeAPI;
    }

    private void addAdditionalDataFromYoutubeApi(Video video) {
        try {
            VideoData videoData = youtubeAPI.getVideoDataForId(video.getUri().split(":")[2]);
            Snippet snippet = videoData.getItems().get(0).getSnippet();
            Statistics statistics = videoData.getItems().get(0).getStatistics();
            video.setDescription(snippet.getDescription());
            video.setLikeCount(statistics.getLikeCount());
            video.setDislikeCount(statistics.getDislikeCount());
            video.setViewCount(statistics.getViewCount());
            video.setThumbnailUrlSmall(snippet.getThumbnails().getStandard() != null ? snippet.getThumbnails().getStandard().getUrl() : null);
            video.setThumbnailUrlMedium(snippet.getThumbnails().getMedium() != null ? snippet.getThumbnails().getMedium().getUrl() : null);
            video.setThumbnailUrlLarge(snippet.getThumbnails().getHigh() != null ? snippet.getThumbnails().getHigh().getUrl() : null);
            video.setThumbnailUrlMaxRes(snippet.getThumbnails().getMaxres() != null ? snippet.getThumbnails().getMaxres().getUrl() : null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Video getVideoFromEntry(SyndEntry entry) {
        Video video = new Video();
        video.setChannelName(entry.getAuthor());
        video.setVideoUrl(entry.getLink());
        video.setTitle(entry.getTitle());
        video.setChannelUrl(entry.getLink());
        video.setUri(entry.getUri());
        addAdditionalDataFromYoutubeApi(video);
        return video;
    }
}
