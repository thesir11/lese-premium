/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.lese.presenters.interfaces;

import game.lese.house.House;

/**
 *
 * @author bruno
 */
public interface MessagePresenter {

    /**
     * Displays the question to the player.
     *
     * @param house
     */
    void showContent(House house);

}
