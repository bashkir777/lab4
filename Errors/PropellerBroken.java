package Errors;

public class PropellerBroken extends Exception{
    public PropellerBroken(){
        super();
    }

    @Override
    public void printStackTrace() {
        System.err.println("Пропеллер сломан, полет невозможен");
    }
}
