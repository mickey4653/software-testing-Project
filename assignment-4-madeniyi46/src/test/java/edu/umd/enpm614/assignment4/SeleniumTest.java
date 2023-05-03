package edu.umd.enpm614.assignment4;

import java.io.File;
import java.util.Objects;

public class SeleniumTest {
    /* **************************************************************************
     * ********   This is a helper class DO NOT change code in here    **********
     * **************************************************************************/

    public static void setUpWebDriver(String resource) {
        ClassLoader classLoader = SeleniumTest.class.getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource(resource),
                resource + " not found.").getFile());
        String absolutePath = file.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absolutePath);
    }
}
