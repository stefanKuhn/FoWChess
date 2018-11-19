/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logger;

import Objects.Mob;
import Objects.Tile;
import fowchess.FoWChess;
import java.util.ArrayList;

/**
 *
 * @author danie
 */
public class Logger {

    private static Logger instance;
    private ArrayList<String> log;
    private String lastEntry;
    private Mob victimOfEnPassant;

    private Logger() {
        this.log = new ArrayList();
    }

    public ArrayList<String> getLog() {
        return log;
    }

    public Mob getVictimOfEnPassant() {
        return victimOfEnPassant;
    }

    public void setVictimOfEnPassant(Mob victimOfEnPassant) {
        this.victimOfEnPassant = victimOfEnPassant;
    }

    public void setLog(ArrayList<String> log) {
        this.log = log;
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void addEntry(String newEntry) {
        System.out.println(newEntry);
        log.add(0, newEntry);
        if (log.size() > FoWChess.getHeight() + 2) {
            log.remove(log.size() - 1);
        }
        FoWChess.updateLog();
    }

    public void newEntry(Mob attacker, Tile battlefield) {
        lastEntry = attacker.getName() + " beats " + battlefield.getMob().getName() + " at (" + String.valueOf(battlefield.getX() + 1) + "," + String.valueOf(battlefield.getY() + 1) + ")";
        addEntry(lastEntry);
    }

    public void newEntryEnassant(Mob attacker, Tile battlefield) {
        lastEntry = attacker.getName() + " beats " + victimOfEnPassant.getName() + " en passant at (" + String.valueOf(battlefield.getX() + 1) + "," + String.valueOf(battlefield.getY() + 1) + ")";
        addEntry(lastEntry);
    }

}
