package Classes;

import AbstractClasses.Human;
import AbstractClasses.Thing;
import Errors.PropellerBroken;
import Interfaces.DropAble;
import Enums.Conditions;

public class Carlson extends Human implements DropAble {
    public Carlson(String name, Place place){
        super(name, place);
    }
    private class Propeller extends Thing {
        public Propeller() {
            super("пропеллер", false);
        }
    }
    private Propeller propeller = new Propeller();

    @Override
    public void dropThing(Place place){
        System.out.println(this.toString() + " выбрасывает " + this.getThing().toString()+ " на "+ place.toString());
        this.getThing().broken();
        this.setThing();
        for (int i =0; i < 3; i++){
            if (place.getHumanList()[i] != null){
                place.getHumanList()[i].setCondition(Conditions.ANGRY);
            }
        }
    }

    @Override
    public void setCondition(Conditions condition) {
        super.setCondition(condition);

        switch (condition){
            case FUNNY:
                System.out.println(this.toString() + " издает, какой-то радостный звук, похожий на кудахтанье");
                break;
            case GAMBLE:
                System.out.println("глаза " + this.toString() + "a загорелись");
                break;
        }
    }
    public void fly() throws PropellerBroken {
        if (this.propeller.isBroken()){
            throw new PropellerBroken();
        }
        switch (this.getCondition()){
            case GAMBLE:
                System.out.println(this.toString()+ " взлетел и приземлился");
                System.out.println(this.toString() + " снова взлетает под потолок");
                System.out.println(this.toString() + " грузно шмякается на пол");
                break;
            case CALM:
                System.out.println(this.toString()+" взлетел");
                System.out.println(this.toString()+" приземлился");
                break;
        }

    }
    @Override
    public void setThing(Thing thing){
        super.setThing(thing);
        if (this.getCondition() == Conditions.GAMBLE){
            System.out.println(this.toString() + " схватил " + this.getThing().toString());
        } else{
            System.out.println(this.toString() + " берет " + this.getThing().toString());
        }
    }
    @Override
    public void runTo(Place place){
        this.setPlace(place);
        System.out.println(this.toString() + " со всех ног побежал в " + place.toString());
        PlaceController.addHuman(place, this);
    }
    @Override
    public void onGo(Place place){
        if (this.propeller.isBroken()){
            System.out.println(this.toString() + " идет пешком в "+ place.toString());
        }else{
            System.out.println(this.toString() + " летит в "+place.toString());
        }
    }
}
