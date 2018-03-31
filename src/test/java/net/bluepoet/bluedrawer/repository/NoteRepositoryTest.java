package net.bluepoet.bluedrawer.repository;

import net.bluepoet.bluedrawer.domain.Note;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Created by bluepoet on 2018. 3. 30..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(value = false)
public class NoteRepositoryTest {
    @Autowired
    NoteRepository repository;

    @After
    public void cleanup() throws Exception {
        repository.deleteAll();
    }

    @Test
    public void addAndgetNote() {
        // given
        repository.save(Note.builder()
                .title("test")
                .link("http://bluepoet.me")
                .build());
        // when
        List<Note> notes = repository.findAll();

        // then
        Note note = notes.get(0);
        assertThat(note.getTitle()).isEqualTo("test");
        assertThat(note.getLink()).isEqualTo("http://bluepoet.me");
    }

    @Test
    public void verifyCreatedDate() {
        // given
        LocalDateTime now = LocalDateTime.now();
        repository.save(Note.builder()
                .title("test1")
                .link("http://bluepoet1.me")
                .build());

        // when
        List<Note> notes = repository.findAll();

        // then
        Note note = notes.get(0);
        assertThat(note.getCreatedDate().isAfter(now)).isTrue();
    }
}

