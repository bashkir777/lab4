package Classes;

import AbstractClasses.Human;
import Classes.Place;

public class PlaceController {
    public static void addHuman(Place place, Human human){
        place.getHumanList()[place.getHumanCounter()] = human;
        place.setHumanCounter((short)(place.getHumanCounter()+1));
    }
    public static void removeHuman(Place place, Human human){
        for (int i = 0; i < 3; i++){
            if (human.equals(place.getHumanList()[i])){
                //System.out.println(human.toString() + " покидает " + place.toString());
                place.getHumanList()[i] = null;
            }
        }
        place.setHumanCounter((short)(place.getHumanCounter()-1));
    }
}