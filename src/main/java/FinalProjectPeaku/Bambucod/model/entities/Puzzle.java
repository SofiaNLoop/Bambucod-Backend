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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String difficulty;
    private String category;

}
