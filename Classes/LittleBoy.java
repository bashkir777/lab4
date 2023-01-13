package Classes;

import AbstractClasses.Human;
import Enums.Conditions;

public class LittleBoy extends Human {
    public LittleBoy(String name, Place place) {
        super(name, place);
    }
    @Override
    public void runTo(Place place){
        this.setPlace(place);
        switch (this.getCondition()){
            case GAMBLE:
                System.out.println(this.toString() + ", раздираемый любопытством, бросился в " + place.toString());
                break;
            case SCARED:
                System.out.println(this.toString() + " побежал в " + place.toString() + " полный дурных предчувствий");
                break;
        }
        PlaceController.addHuman(place, this);
    }

    @Override
    public void setCondition(Conditions condition) {
        super.setCondition(condition);
        switch (condition){
            case HAPPY:
                System.out.println(this.toString() + " покраснел, так он был счастлив");
                break;
        }
    }
    @Override
    public void onGo(Place place){
        System.out.println(this.toString() + " направляеться в " + place.toString());
    }
    public void dontUnderstand(){
        System.out.println(this.toString()+" не знает что ответить");
    }

}
