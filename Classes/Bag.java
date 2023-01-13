package Classes;

import AbstractClasses.Thing;

public class Bag extends Thing {
    public Bag(String name, boolean isFilled){
        super(name, isFilled);
    }
    @Override
    public void broken(){
        super.broken();
        System.out.println(this.toString() + " разрывается словно бомба");
    }
}