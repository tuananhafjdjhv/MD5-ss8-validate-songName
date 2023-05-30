package ra.ra.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ra.ra.model.Song;

public interface ISongService {
    Page<Song> findAll(Pageable pageable);
    void save(Song sing);
}
