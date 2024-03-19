package FinalProjectPeaku.Bambucod.service;

import FinalProjectPeaku.Bambucod.model.entities.Puzzle;
import FinalProjectPeaku.Bambucod.repository.PuzzleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PuzzleService {

    private final PuzzleRepository puzzleRepository;

    public List<Puzzle> getAllPuzzles(){
        return puzzleRepository.findAll();
    }
}
