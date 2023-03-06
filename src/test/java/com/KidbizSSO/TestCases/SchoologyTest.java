package com.KidbizSSO.TestCases;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Method.CoursePage;
import com.KidbizSSO.Method.Schoology;
import com.KidbizSSO.Method.SchoologyHomepage;

public class SchoologyTest extends BaseClass {

	Schoology schoology;
	SchoologyHomepage homepage;
	CoursePage coursePage;
	
	SoftAssert sf = new SoftAssert();

	@BeforeMethod
	public void initialisation() {
		browserInitialization();
		wd.get(properties.getProperty("schoologyUrl"));
		wait = new WebDriverWait(wd, 10);
		wd.manage().window().maximize();
		schoology = new Schoology();
	}

	@Test
	public void schoologyPage() {

		schoology.email(properties.getProperty("emailSchoology"));
		schoology.pass(properties.getProperty("passSchoology"));
		homepage = schoology.signIn();
		// need to put assertion check for this page
//		sf.assertEquals(null, null, null);
		
		// Redirecting to course page
		coursePage= homepage.clickOnCourse();
		
	}

}