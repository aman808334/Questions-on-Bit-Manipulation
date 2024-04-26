
// Number of valid words for each puzzle

/*
Given array of words & puzzles
Find the count that how many words satisfy the puzzle. Every puzzle will have separate count.

Rules to Satisfy - 

(1) Word should contain 1st character of puzzle
(2) Puzzle must contain all characters of wprds(Duplicates isn't considered).

Example - 

Input -> words = ["aaa","asas","able"] and puzzle = ["abolveyz", "abslute"]
Output -> [2,3]

Explanation - 

Puzzle         Words

abolveyz       aaaa, asas, able  -> 2
abslute        aaaa, asas, able  -> 3
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Number_Of_Valid_Words_For_Each_Puzzle {

    public static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {

        // Will create HM of character(a-z) & AL of integer, which will have words with contain that character

        Map<Character,List<Integer>> hm = new HashMap<>();

        for(char i=97; i<=122; i++){
            hm.put(i,new ArrayList<Integer>()); // Currently list is empty
        }

        for(String word:words){

            // Make mask of word
            int mask = 0;

            for(char c: word.toCharArray()){
                int bit = c - 'a';
                mask = (mask | (1<<bit));
            }

            // Put that mask in HM

            /* If word is "abab" then it should it should go in 'a' & 'b' one-one time only.
            So checker*/

           int checker = 0;
        
            for(char c: word.toCharArray()){

                if( (checker & (1 << (c -'a'))) == 0) {
                    hm.get(c).add(mask);
                    checker = checker | (1 << (c-'a'));
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        // Puzzles

        for(String puzzle:puzzles){
            
            // Make mask of puzzle
            int puzzlemask = 0;

            for(char c: puzzle.toCharArray()){
                int bit = c - 'a';
                puzzlemask = puzzlemask | (1<<bit);
            }

            char firstchar = puzzle.charAt(0);
            int count = 0;

            for(int wordmask:hm.get(firstchar)){
                if((wordmask & puzzlemask) == wordmask)
                  count++;
            }
           result.add(count); 
        }
      return result;  
    }

    public static void main(String[] args) {
        String words[] = {"aaaa","asas","able","ability","actt","actor","access"};
        String puzzles[] = {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};
        System.out.println(findNumOfValidWords(words, puzzles));
    }
}