import AbstractClasses.Human;
import Classes.*;
import Enums.Conditions;
import Errors.InteractionImpossible;
import Errors.PropellerBroken;

public class Main {
    public static void main(String[] args) throws InteractionImpossible {
        Place street = new Place("улица");
        Place cafe = new Place("молочное кафе в соседнем доме");
        Place room = new Place("комната");
        Place bathroom = new Place("ванная комната");
        Tap tap = new Tap(bathroom);
        Window window = new Window(street);
        room.setInteractiveObj(window);
        Human stranger = new Human("тетенька", street){
            @Override
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
        };
        Carlson carl = new Carlson("Карлсон", room);
        LittleBoy boy = new LittleBoy("малыш", room);
        boy.dontUnderstand();
        carl.setCondition(Conditions.FUNNY);
        carl.setCondition(Conditions.GAMBLE);
        carl.setThing(new Bag("пакет", true));
        carl.runTo(bathroom);
        boy.setCondition(Conditions.GAMBLE);
        boy.runTo(bathroom);
        bathroom.getInteractiveObj().interaction(carl);
        carl.runTo(room);
        boy.setCondition(Conditions.SCARED);
        boy.runTo(room);
        stranger.onGo(cafe);
        room.getInteractiveObj().interaction(carl);
        room.getInteractiveObj().interaction(boy);
        try{
            carl.fly();
        }catch (PropellerBroken e){
            e.printStackTrace();
        }
        boy.setCondition(Conditions.HAPPY);
    }
}