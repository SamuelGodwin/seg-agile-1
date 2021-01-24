import static org.junit.Assert.assertTrue;
import org.junit.Test;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JOptionPane;
import com.athaydes.automaton.Swinger;
import static com.athaydes.automaton.selector.StringSelectors.matchingAny;
public class DriverIntegrationTest{

  @Test
  public void testNormalUse(){
    new  c.MainGUI();
    Swinger swinger = Swinger.forSwingWindow();
    swinger.pause(500);
    swinger.clickOn("name:add new task")
            .pause(500)
            .clickOn("name:nameField")
            .type("Enio")
            .pause(500)
            .clickOn("type:JSpinner")
            .type("1")
            .pause(500)
            .clickOn("name:save");


  }


}
