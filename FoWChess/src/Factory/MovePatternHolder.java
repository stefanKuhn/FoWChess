/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import MovePattern.MovePattern;

/**
 *
 * @author Sumpf
 */
public class MovePatternHolder {
    MovePattern pawn, rook, bishop, knight, queen, king;
    static MovePatternHolder instance;
    
    private MovePatternHolder(){
        init();
    }
    
    public static MovePatternHolder getInstance(){
        if (instance == null){
            instance = new MovePatternHolder();
        }
        return instance;
    }
    
    public void init(){
        
    }
    
    public void makePawnPattern(){
        
    }
}
