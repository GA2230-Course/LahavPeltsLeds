package src.codes;
import LedsSim.*;

public abstract class AnimationBase {
    protected LedStrip strip;

    
    public void setStrip(LedStrip strip){
        this.strip = strip;
    } 
    //adad
    public abstract void init();
    public abstract void periodic();
}
