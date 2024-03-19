package FinalProjectPeaku.Bambucod.controller;

import FinalProjectPeaku.Bambucod.model.entities.Puzzle;
import FinalProjectPeaku.Bambucod.repository.PuzzleRepository;
import FinalProjectPeaku.Bambucod.service.PuzzleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/puzzle")
@RequiredArgsConstructor
public class PuzzleController {

    private final PuzzleService puzzleService;

    @GetMapping(value= "list")
    public List<Puzzle> welcome (){
        return puzzleService.getAllPuzzles();
    }

}
