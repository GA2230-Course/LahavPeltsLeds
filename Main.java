import LedsSim.LedSim;
import java.awt.Color;

import src.codes.AnimationTimed;
import src.codes.BlinkAnimation;
import src.codes.MostBeautifulAnimation;
import src.codes.LedController;
import src.codes.RandomAnimationGroup;
import src.codes.SequentialAnimationGroup;
import src.codes.SolidAnimation;

public class Main {
    public static void main(String[] args) {

        
        LedSim ledSim = LedSim.getRowsSim(100);
        LedController LC = new LedController(ledSim);


        BlinkAnimation blinkAnimation = new BlinkAnimation(new Color(100, 0, 40), 1);
        MostBeautifulAnimation coolAnimation = new MostBeautifulAnimation(new Color(0, 100, 40), 1);


        AnimationTimed blink = new AnimationTimed(blinkAnimation, 2);
        AnimationTimed cool = new AnimationTimed(coolAnimation, 6);

        RandomAnimationGroup randomAnimationGroup = new RandomAnimationGroup(blink, cool);

        LC.setAnimation(randomAnimationGroup);

        while (true)
            LC.periodic();
    }
}
