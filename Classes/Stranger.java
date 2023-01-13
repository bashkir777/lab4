package Classes;

import AbstractClasses.Human;
import Classes.Place;
import Enums.Conditions;

public class Stranger extends Human {
    public Stranger(String name, Place place){
        super(name, place);
    }
    public void onGo(Place place1){
        System.out.println(this.toString() + " идет в " + place1.toString());
    }

    @Override
    public void setCondition(Conditions condition) {
        super.setCondition(condition);
        if (condition == Conditions.ANGRY){
            System.out.println(this.toString() + " злится");
        }
    }
}