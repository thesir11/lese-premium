/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.lese.presenters.interfaces;

import game.lese.house.House;
import game.lese.model.Joker;
import java.util.List;

/**
 *
 * @author bruno
 */
public interface JokerPresenter {
    
    /**
     * Displays the joker to the player.
     *
     * @param house
     */
    void showContent(House house);
    
    /**
     * Displays message.
     *
     * @param feedback
     */
    void showMessage(String feedback);
    /**
     * Get new joker to register.
     *
     * @return 
     */
    Joker getNewJoker();
    
    /**
     * Confirmation joker's register.
     *
     * @return 
     */
    boolean confirmResgisterJoker();

    public Joker getJokerForEdit(List<Joker> allJokers);

    public Joker editJoker(Joker selectedJoker);
}
