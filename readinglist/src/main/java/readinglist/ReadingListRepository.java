package readinglist;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Bijon on 3/30/2017.
 */
public interface ReadingListRepository extends JpaRepository<Book, Long> {
    List<Book> findByReader(String book);
}
