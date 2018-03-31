package net.bluepoet.bluedrawer.domain.api;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bluepoet.bluedrawer.domain.Note;

/**
 * TODO : DTO를 suffix에 붙여야 되는지 고민필요
 * Created by bluepoet on 2018. 3. 30..
 */
@Getter
@Setter
@NoArgsConstructor
public class NoteDto {
    private String title;
    private String link;

    public Note toEntity() {
        return Note.builder()
                .title(this.title)
                .link(this.link)
                .build();
    }
}
