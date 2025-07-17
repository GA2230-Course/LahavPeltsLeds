import LedsSim.LedSim;
import java.awt.Color;

import src.codes.AnimationTimed;
import src.codes.BlinkAnimation;
import src.codes.MostBeautifulAnimation;
import src.codes.SequentialAnimationGroup;
import src.codes.LedController;

public class Main {
    public static void main(String[] args) {

        LedSim ledSim = LedSim.getRowsSim(100);
        LedController LC = new LedController(ledSim);

        BlinkAnimation blinkAnimation = new BlinkAnimation(new Color(100, 0, 40), 5);
        MostBeautifulAnimation coolAnimation = new MostBeautifulAnimation(new Color(0, 100, 40), 5);

        LC.setAnimation(new AnimationTimed(blinkAnimation, 10.0));
        LC.setDefaultAnimation(coolAnimation);

        SequentialAnimationGroup sequentialAnimationGroup = new SequentialAnimationGroup(
            blinkAnimation, coolAnimation, blinkAnimation, coolAnimation
        );

        LC.setAnimation(sequentialAnimationGroup);

        while (true)
            LC.periodic();
    }
}
