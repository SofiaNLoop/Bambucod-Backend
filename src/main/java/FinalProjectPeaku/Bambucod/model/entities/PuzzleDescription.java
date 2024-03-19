package FinalProjectPeaku.Bambucod.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "puzzle_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PuzzleDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;


}
