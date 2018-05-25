package video.chronologic.api.controller;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import video.chronologic.api.dto.SubRequest;
import video.chronologic.api.dto.Video;
import video.chronologic.api.redis.YoutubeRepo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/apiBase")
public class ApiController {

    private final YoutubeRepo youtubeRepo;

    public ApiController(YoutubeRepo youtubeRepo) {
        this.youtubeRepo = youtubeRepo;
    }

    @PostMapping
    public ResponseEntity<List<Video>> getSubFeed(@RequestBody SubRequest data) throws IOException, FeedException {
        return ResponseEntity.ok(buildSubFeed(getUrlsFromStrings(data.getChannelUrls())));
    }

    private List<URL> getUrlsFromStrings(List<String> stringList) {
        List<URL> returnList = new ArrayList<>();
        stringList.forEach(string -> {
            try {
                returnList.add(new URL(string));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        });

        return returnList;
    }


    private List<Video> buildSubFeed(List<URL> channelUrls) throws IOException, FeedException {
        List<Video> returnList = new ArrayList<>();

        for (URL channelUrl : channelUrls) {
            SyndFeed feed = new SyndFeedInput().build(new XmlReader(channelUrl));
            returnList.addAll(youtubeRepo.getVideosForFeed(feed));
        }

        return returnList;
    }


}
