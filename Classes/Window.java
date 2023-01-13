package Classes;

import AbstractClasses.Human;
import Classes.Place;
import Errors.InteractionImpossible;
import Interfaces.*;
import Enums.Conditions;

public class Window implements Interactive {
    private Place viewOn;
    private boolean interactionPossible = true;
    public Window(Place plc){
        this.viewOn = plc;
    }
    @Override
    public void interaction(Human human) {
        if (!(this.interactionPossible)){
            throw new InteractionImpossible("окно закрыто");
        }
        if (human instanceof DropAble){
            System.out.println(human.toString() + " " + "высовывается в окно");
            DropAble human_drop = (DropAble) human;
            human_drop.dropThing(viewOn);
            Human list[] = human.getPlace().getHumanList();
            for (int i =0; i < 3; i++){
                if(!(list[i]==null) & !(human.equals(list[i]))) {
                    list[i].setCondition(Conditions.SCARED);
                }
            }
        }
        else{
            System.out.println(human.toString() + " закрывает окно");
            this.interactionPossible = false;
        }

    }
}
