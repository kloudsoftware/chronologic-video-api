package video.chronologic.api.controller;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import video.chronologic.api.util.YoutubeAPI;
import video.chronologic.api.util.youtubeDTO.VideoData;

import java.io.IOException;
import java.net.URL;

@Controller
@RequestMapping("/api/apiBase")
public class ApiController {

    private final YoutubeAPI youtubeAPI;

    public ApiController(YoutubeAPI youtubeAPI) {
        this.youtubeAPI = youtubeAPI;
    }

    @GetMapping
    public ResponseEntity<String> index() throws IOException, FeedException {
        String url = "https://www.youtube.com/feeds/videos.xml?channel_id=UC599MoN2FAQyhHeopdKDHqA";
        SyndFeed feed = new SyndFeedInput().build(new XmlReader(new URL(url)));
        VideoData videoData = youtubeAPI.getVideoDataForId(feed.getEntries().get(0).getUri().split(":")[2]);
        return ResponseEntity.ok("Success!");
    }
}
