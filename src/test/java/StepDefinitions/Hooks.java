package StepDefinitions;

import Base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks extends TestBase {
    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void setUp() {
        logger.info("Setting up test environment");
        initializeDriver();
        openWebSite();
    }

    @After
    public static void tearDown() {
        logger.info("Tearing down test environment");
        TestBase.tearDown();
    }
}