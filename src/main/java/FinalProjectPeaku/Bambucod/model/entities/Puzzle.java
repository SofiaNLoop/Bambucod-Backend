package FinalProjectPeaku.Bambucod.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "puzzles")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Puzzle {

    @Id
    private String id;
    private String title;
    private String difficulty;
    private String category;

}
