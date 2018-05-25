package video.chronologic.api.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/api/xml")
public class XmlController {

    @PostMapping
    public ResponseEntity<List<String>> getChannelFeedFromXml(@RequestParam(value = "file") MultipartFile file) throws IOException {
        List<String> returnList = new ArrayList<>();
        String rawContent = IOUtils.toString(file.getInputStream());
        Pattern pattern = Pattern.compile("(?<=xmlUrl=\\\")[^\"]*");
        Matcher matcher = pattern.matcher(rawContent);

        while (matcher.find()) {
            returnList.add(matcher.group());
        }

        return ResponseEntity.ok(returnList);

    }

}
