package Errors;

public class PropellerBroken extends Exception{
    public PropellerBroken(){
        super("Пропеллер сломан, полет невозможен");
    }
}
