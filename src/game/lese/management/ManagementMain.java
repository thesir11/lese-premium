/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.lese.management;

import game.lese.presenters.console.ConsoleTeacherPresenter;
import game.lese.presenters.interfaces.TeacherPresenter;

/**
 *
 * @author cass
 */
public class ManagementMain {
    private final Manager teacherBoard;
    private final TeacherPresenter teacherPresenter;

    
    public ManagementMain() {
        teacherPresenter = new ConsoleTeacherPresenter();
        teacherBoard = new Manager();
    }
    
    public void showMenu() {
        this.teacherBoard.logIn();
        Management management;
        
        while (this.teacherBoard.isAuthenticated()) {
            switch (teacherPresenter.showMenu()) {
                case 1:
                    management = new ManagementQuestion();
                    management.create();
                    break;
                case 2:
                    management = new ManagementQuestion();
                    management.alter();
                    break;
                case 3:
                    management = new ManagementJoker();
                    management.create();
                    break;
                case 4:
                    management = new ManagementJoker();
                    management.alter();
                    break;
                case 5:
                    this.teacherBoard.changePassword();
                    break;
                case 6:
                    this.teacherBoard.logout();
                    teacherPresenter.showExitRestrictedArea();
                    break;
                default:
                    teacherPresenter.showDefault();
                    break;
           }
        }
    }
}
