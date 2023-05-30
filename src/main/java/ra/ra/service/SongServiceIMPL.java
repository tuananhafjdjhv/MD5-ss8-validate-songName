package ra.ra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import org.springframework.stereotype.Service;
import ra.ra.model.Song;
import ra.ra.repository.ISongRepository;

@Service
public class SongServiceIMPL implements ISongService{
    @Autowired
    private ISongRepository songRepository;
    @Override
    public Page<Song> findAll(Pageable pageable) {
       return songRepository.findAll(pageable);
    }

    @Override
    public void save(Song sing) {
        songRepository.save(sing);
    }
}
