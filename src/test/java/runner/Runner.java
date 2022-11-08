package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterSuite;

/*
1. Please change/adjust tags accordingly to run desired test/tests based on feature files
2. tags -> @regression is for running all tests
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature",
        glue = {"stepDef"},
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"},
        tags = "@HR_TC008"
)

/*
1. To generate report add "extends AbstractTestNGCucumberTests" after Runner
   and uncomment all comments under @AfterSuite
2. Left Runner class empty to run testing
 */

public class Runner {
//    @AfterSuite
//    public void generateReport(){
//        ReportingUtils.generateJVMReport();
//    }
}