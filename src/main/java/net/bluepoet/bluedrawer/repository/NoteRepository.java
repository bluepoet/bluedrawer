package net.bluepoet.bluedrawer.repository;

import net.bluepoet.bluedrawer.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by bluepoet on 2018. 3. 30..
 */
public interface NoteRepository extends JpaRepository<Note, Long> {
}
