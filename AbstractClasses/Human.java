package AbstractClasses;
import Classes.*;
import Enums.Conditions;
public abstract class Human {
    private String name;
    private Conditions condition;
    private Place place;
    private Thing thing;

    public Human(String name, Place place){
        this.name = name;
        this.condition = Conditions.CALM;
        this.place = place;
        PlaceController.addHuman(place, this);
    }

    public Thing getThing() {
        return thing;
    }

    public void setThing(Thing thing) {
        this.thing = thing;
    }
    public void setThing() {
        this.thing = null;
    }
    public Place getPlace(){
        return this.place;
    }
    public void setPlace(Place place) {
        PlaceController.removeHuman(this.getPlace(), this);
        this.place = place;
    }


    public void setCondition(Conditions condition) {
        this.condition = condition;
    }
    public Conditions getCondition(){
        return this.condition;
    }


    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int hashCode(){
        int result = this.name.hashCode();
        result += 31 * result + (this.thing!=null ? this.thing.hashCode() : 0);
        result += 31 * result + (this.place.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Human)) return false;
        if(this==obj) return true;
        Human human = (Human) obj;
        if (!(this.name.equals(human.name)))return false;
        if (!(this.place.getName().equals(human.place.getName())))return false;
        if(!(this.thing.getName().equals(human.thing.getName())))return false;
        return true;
    }
    public void runTo(Place place){
        this.setPlace(place);
        System.out.println(this.toString() + " заходит в " + place.toString());
        PlaceController.addHuman(place, this);
    }

    abstract public void onGo(Place place);
}