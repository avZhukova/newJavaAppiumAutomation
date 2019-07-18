package lib.UI.ios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import lib.UI.NavigationUI;

public class iOSNavigationUI extends NavigationUI {


    static {
        MY_LISTS_LINK = "id:Saved";



    }



    public iOSNavigationUI(AppiumDriver driver){

        super(driver);

    }

}
