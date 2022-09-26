package com.juandavid.mutantes.mutantes.web.controller;

import com.juandavid.mutantes.mutantes.domain.dto.RequestMutantDto;
import com.juandavid.mutantes.mutantes.domain.services.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mutant")
public class MutantController {

    @Autowired
    private StatService statService;

    @GetMapping
    public ResponseEntity<?> get(){
        return new ResponseEntity<>("Hola ...", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> isMutant(@RequestBody RequestMutantDto requestMutantDto){
        String dna[]  = requestMutantDto.getDna();
        int row = dna.length;
        int column = dna.length;
        char[][] grid = new char[row][column];
        int offset = 0;
        // Convert json to matrix
        for (int i = 0; i < dna.length; i++) {
            for (String s : dna[i].split("")){
                grid[i][offset] = s.charAt(0);
                offset = offset + 1;
            }
            offset = 0;
        }
        // Using functions
        int resulVertically = searchVertically(grid);
        int resulHorizontally = searchHorizontally(grid);
        int resulDiagonal = searchDiagonal(grid);


        if(resulVertically > 0 || resulHorizontally > 0 || resulDiagonal > 0){
            statService.save(true);
            return new ResponseEntity<>( "Mutante Encontrado !! \n DNA Encontrados Vertical: " + resulVertically + ", DNA Encontrados Horizontal: " + resulHorizontally + ", DNA Encontrados Diagonal: " + resulDiagonal,HttpStatus.OK);
        }else{
            statService.save(false);
            return new ResponseEntity<>("Humano Encontrado !!", HttpStatus.FORBIDDEN);
        }
    }
    static int searchHorizontally(char[][] grid) {
        int matches = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length-3; j++) {
                if (grid[i][j] == grid[i][j+1] && grid[i][j] == grid[i][j+2] && grid[i][j] == grid[i][j+3])
                {
                    matches += 1;
                }
            }
        }
        return matches;
    }
    static int searchVertically(char[][] grid) {
        int matches = 0;
        for (int i = 0; i < grid[0].length-3; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == grid[i+1][j] && grid[i][j] == grid[i+2][j] && grid[i][j] == grid[i+3][j])
                {
                    matches += 1;
                }
            }
        }
        return matches;
    }
    static int searchDiagonal(char[][] grid) {
        int matches = 0;
        for (int i = 0; i < grid.length-3; i++) {
            for (int j = 0; j < grid[0].length-3; j++) {
                if (grid[i][j] == grid[i+1][j+1] && grid[i][j] == grid[i+2][j+2] && grid[i][j] == grid[i+3][j+3]) {
                    matches += 1;
                }
            }
        }
        return matches;
    }

}
