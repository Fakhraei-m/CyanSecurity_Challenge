package com.cs.qa.cucumber.stepDefinitions;

import com.cs.qa.base.TestBase;
import com.cs.qa.pages.SecurePage;
import com.cs.qa.pages.LoginPage;
import com.cs.qa.util.TestUtil;

public class PageCollectionForStpDfntions extends TestBase{

	//these attributes are accessible from all the xxxStpDfntion classes
	//must be static
	//I removed them from each xxxStpDfntion classes
	static LoginPage loginPage;
	static SecurePage securePage;
	static TestUtil testUtil;
}
