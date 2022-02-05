package frc.team1699.utils;
import edu.wpi.first.wpilibj.DigitalInput;
public class LimitSwitch {
    private DigitalInput lswitch;

    public LimitSwitch(int port) {
        lswitch = new DigitalInput(port);
    }
    public boolean isPressed() {
        return lswitch.get();
    }
}
