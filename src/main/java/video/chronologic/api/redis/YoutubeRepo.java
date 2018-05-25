package video.chronologic.api.redis;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import video.chronologic.api.dto.Video;
import video.chronologic.api.services.YoutubeService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class YoutubeRepo {
    private final RedisTemplate<String, Video> redisTemplate;
    private final YoutubeService youtubeService;


    @Autowired
    public YoutubeRepo(RedisTemplate<String, Video> redisTemplate, YoutubeService youtubeService) {
        this.redisTemplate = redisTemplate;
        this.youtubeService = youtubeService;
    }

    public List<Video> getVideosForFeed(SyndFeed feed) {
        return feed.getEntries()
                .stream()
                .map(this::getVideoForEntry)
                .collect(Collectors.toList());
    }

    @SuppressWarnings("ConstantConditions")
    private Video getVideoForEntry(SyndEntry entry) {
        Optional<Video> videoOptional = Optional.ofNullable(this.redisTemplate.opsForValue().get(entry.getUri()));

        return videoOptional.orElseGet(() -> insertMissing(entry));

    }

    private Video insertMissing(SyndEntry entry) {
        Video video = youtubeService.getVideoFromEntry(entry);
        redisTemplate.opsForValue().set(entry.getUri(), video);
        return video;
    }
}