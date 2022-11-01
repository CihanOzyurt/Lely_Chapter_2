package StepDefinitions;

import Utilities.GWD;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks {

    @After
    public void after(Scenario scenario)
    {
        System.out.println("scenario status = "+ scenario.getStatus());
        System.out.println("scenario is failed ? = "+ scenario.isFailed());

        GWD.quitDriver();
    }
}
