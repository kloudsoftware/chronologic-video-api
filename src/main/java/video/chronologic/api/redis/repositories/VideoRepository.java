package video.chronologic.api.redis.repositories;

import org.springframework.data.repository.CrudRepository;
import video.chronologic.api.dto.Video;

import java.util.List;

public interface VideoRepository extends CrudRepository<Video, String> {
    List<Video> findAll();
}
