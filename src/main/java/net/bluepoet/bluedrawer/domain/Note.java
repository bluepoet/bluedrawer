package net.bluepoet.bluedrawer.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * TODO : class 이름은 추후 또 고민. 지금은 일단 Note
 * Created by bluepoet on 2018. 3. 30..
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "note")
public class Note extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String link;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Builder
    public Note(Long id, String title, String link) {
        this.id = id;
        this.title = title;
        this.link = link;
    }

    public void addCategory(Category category) {
        this.category = category;
    }
}