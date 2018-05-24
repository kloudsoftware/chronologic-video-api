package video.chronologic.api.util;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import video.chronologic.api.util.youtubeDTO.VideoData;

import java.io.IOException;

@Service
public class YoutubeAPI {

    private static final Gson GSON = new Gson();

    private static final String youtubeVideoBase = "https://www.googleapis.com/youtube/v3/videos";
    private static final String youtubeUrlSingleVideoBase = youtubeVideoBase + "?id=";
    private static final String listPartParam = "&part=snippet%2CcontentDetails%2Cstatistics";
    private static final String apiKeyParam = "&key=";
    @Value("${api.key}")
    private String apiKey;

    public VideoData getVideoDataForId(String id) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(youtubeUrlSingleVideoBase + id + listPartParam + apiKeyParam + apiKey);
        HttpResponse httpResponse = client.execute(httpGet);
        return GSON.fromJson(IOUtils.toString(httpResponse.getEntity().getContent()), VideoData.class);
    }


}
