package net.bluepoet.bluedrawer.controller;

import lombok.AllArgsConstructor;
import net.bluepoet.bluedrawer.domain.Category;
import net.bluepoet.bluedrawer.domain.Note;
import net.bluepoet.bluedrawer.domain.api.NoteDto;
import net.bluepoet.bluedrawer.repository.NoteRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bluepoet on 2018. 3. 30..
 */
@RestController
@AllArgsConstructor
public class NoteController {
    private NoteRepository noteRepository;

    @PostMapping("/add")
    public void saveNote(@RequestBody NoteDto dto) {
        Category category = Category.builder().id(1L).name("test").build();
        Note note = dto.toEntity();
        note.addCategory(category);
        noteRepository.save(note);
    }
}
