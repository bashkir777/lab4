package Classes;

import AbstractClasses.Human;
import Errors.InteractionImpossible;
import Interfaces.Interactive;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Tap implements Interactive {
    private Place position;

    public Tap(Place place){
        this.position = place;
        place.setInteractiveObj(this);
    }
    @Override
    public void interaction(Human human) {
        if (human.getThing() == null | !(human.getThing().isFilled())){
            throw new InteractionImpossible("Данный предмет невозможно наполнить");
        }else if(human.getThing().getInsideObject() != null){
            throw new InteractionImpossible("В этом предмете, уже содержится какой-то объект");
        }
        class Water{
        }
        human.getThing().setInsideObject(new Water());
        System.out.println(human.toString() + " наполняет " + human.getThing().toString() + " водой");
    }
}
