/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.lese.outcome;

import game.lese.board.PlayerBoard;
import game.lese.house.House;

/**
 *
 * @author cass
 */
public class PenalityOutcome extends HouseOutcome {

    public PenalityOutcome(int nHouses, int points) {
        super(nHouses, points);
    }

    @Override
    public void apply(PlayerBoard p, House house) {
        p.debitPoints(getPoints());
        p.move(getNumberOfHouses());
    }

}
