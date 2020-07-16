package qa.front.friends.logic.driver;


import org.testng.annotations.BeforeMethod;
import qa.front.friends.logic.GetEnv;


import static com.codeborne.selenide.Selenide.open;

public interface DesktopDriver extends GetEnv, Capabilities {

    @BeforeMethod(alwaysRun = true)
    default void initDriver() {
        String grid = getEnv("grid_url");
        if (grid.equals("default")) {
            initLocalCapabilities();
        } else {
            initRemoteCapabilities(grid);
        }
        
        open(getPropFromFile("baseURLTest"));
    }
}
