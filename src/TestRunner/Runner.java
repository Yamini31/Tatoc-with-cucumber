package TestRunner;		

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;		
import cucumber.api.junit.Cucumber;	

@RunWith(Cucumber.class)				
@CucumberOptions(
		features="/home/qainfotech/eclipse-workspace/CcuemberTatoc/Features/MyTest.feature",
        glue={".home.qainfotech.eclipse-workspace.CcuemberTatoc.src.StepDefinations"},
tags = "@b")						
public class Runner 				
{		

	
	
}