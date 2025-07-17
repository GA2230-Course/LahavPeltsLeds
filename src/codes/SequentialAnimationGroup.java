package src.codes;

public class SequentialAnimationGroup extends AnimationBase {
    protected AnimationBase[] animations;
    private int currentAnimationIndex = 0;
    private int numOfAnimations;

    public SequentialAnimationGroup(AnimationBase... animations) {
        this.animations = animations;
        this.numOfAnimations = animations.length;
    }

    @Override
    public boolean isOver() {
        return currentAnimationIndex >= numOfAnimations;
    }

    @Override
    public void init() {
        if (currentAnimationIndex < numOfAnimations) {
            animations[currentAnimationIndex].setStrip(strip);
            animations[currentAnimationIndex].init();
        }
    }

    @Override
    public void periodic() {
        if (currentAnimationIndex < numOfAnimations) {
            AnimationBase current = animations[currentAnimationIndex];
            if (current.isOver()) {
                currentAnimationIndex++;
                if (currentAnimationIndex < numOfAnimations) {
                    animations[currentAnimationIndex].setStrip(strip);
                    animations[currentAnimationIndex].init();
                }
            } else {
                current.periodic();
            }
        }
    }
}
