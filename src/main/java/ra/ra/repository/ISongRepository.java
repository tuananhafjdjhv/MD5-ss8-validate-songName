package ra.ra.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ra.ra.model.Song;

@Repository
public interface ISongRepository extends PagingAndSortingRepository<Song,Long> {

}
