package AbstractClasses;

public abstract class Thing {
    private String name;
    private boolean isFilled;
    private Object insideObject;
    private boolean broken = false;

    public Thing(String name, boolean isFilled) {
        this.name = name;
        this.isFilled = isFilled;
    }

    public void broken(){
        this.broken = true;
    }

    @Override
    public String toString(){
        return this.name;
    }
    @Override
    public int hashCode(){
        return this.name.hashCode();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean isFilled) {
        this.isFilled = isFilled;
    }

    public Object getInsideObject() {
        return insideObject;
    }

    public void setInsideObject(Object insideObject) {
        if (this.isFilled){
            this.insideObject = insideObject;
        }
    }

    public boolean isBroken() {
        return broken;
    }
}