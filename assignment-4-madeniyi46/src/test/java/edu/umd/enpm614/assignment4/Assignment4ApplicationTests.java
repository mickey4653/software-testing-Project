package edu.umd.enpm614.assignment4;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Assignment4ApplicationTests {
	public static WebDriver driver;

	@Value("${local.server.port}")
	private int port;

	@BeforeAll
	public static void setUpClass() throws Exception {
//		Download the version of chrome driver compatible with your OS
//		from here: https://chromedriver.storage.googleapis.com/index.html
//		Copy the unzipped file to "src/test/resources"
//		If you are using Windows, you may need to rename the file to "chromedriver.exe"
//		If you are using Mac/Linux, you may need to rename the file to "chromedriver"
//		Replace the string "chromedriver" below with the name of the file you copied (chromedriver.exe or chromedriver)
		SeleniumTest.setUpWebDriver("chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeEach
	public void setUp () {
		driver.get("http://localhost:" + port + "/index");
	}

	@AfterAll
	public static void tearDownClass() {
		driver.quit();
	}

	@Test
	void contextLoads() throws InterruptedException {
		Thread.sleep(5000);
	}

	@Test
	public void testHomePage() throws InterruptedException{
		driver.get("http://localhost:"+ port + "/index");
		assertEquals("Index - ENPM 614: Assignment 4",driver.getTitle());
		Thread.sleep(2000);

		//find the link to the calculator page
		WebElement calcElement = driver.findElement(By.linkText("Calculator"));
		calcElement.click();
		assertNotNull(calcElement);
		Thread.sleep(2000);

		//find the link to the form page
		WebElement frmElement = driver.findElement(By.linkText("Form"));
		frmElement.click();
		assertNotNull(frmElement);
		Thread.sleep(2000);
	}

	@Test
	public void testCalculator() throws InterruptedException{
		driver.get("http://localhost:" + port + "/math");
		assertEquals("Math - ENPM 614: Assignment 4",driver.getTitle());
		Thread.sleep(2000);

		//Testing for Addition Operator
		driver.get("http://localhost:" + port + "/math?param1=7&param2=10&operator=plus");
		assertEquals("Result: 10+7=17",driver.findElement(By.cssSelector("div.d-block div.card-body p.card-text")).getText());
		Thread.sleep(2000);

		driver.get("http://localhost:" + port + "/math?param1=0&param2=7&operator=plus");
		assertEquals("Result: 7+0=7",driver.findElement(By.cssSelector("div.d-block div.card-body p.card-text")).getText());
		Thread.sleep(2000);

		//for +-
		driver.get("http://localhost:" + port + "/math?param1=15&param2=-7&operator=plus");
		assertEquals("Result: -7+15=8",driver.findElement(By.cssSelector("div.d-block div.card-body p.card-text")).getText());
		Thread.sleep(2000);

		//for -+
		driver.get("http://localhost:" + port + "/math?param1=-15&param2=7&operator=plus");
		assertEquals("Result: 7+-15=-8",driver.findElement(By.cssSelector("div.d-block div.card-body p.card-text")).getText());
		Thread.sleep(2000);

				//for --
		driver.get("http://localhost:" + port + "/math?param1=-20&param2=-60&operator=plus");
		assertEquals("Result: -60+-20=-80",driver.findElement(By.cssSelector("div.d-block div.card-body p.card-text")).getText());
		Thread.sleep(2000);

		driver.get("http://localhost:" + port + "/math?param1=1002&param2=4532&operator=plus");
		assertEquals("Result: 4532+1002=5534",driver.findElement(By.cssSelector("div.d-block div.card-body p.card-text")).getText());
		Thread.sleep(2000);


		//Testing for Subtraction

		//for --
		driver.get("http://localhost:" + port + "/math?param1=-20&param2=-60&operator=minus");
		assertEquals("Result: -60--20=-40",driver.findElement(By.cssSelector("div.d-block div.card-body p.card-text")).getText());
		Thread.sleep(2000);

		//for -+
		driver.get("http://localhost:" + port + "/math?param1=-15&param2=7&operator=minus");
		assertEquals("Result: 7--15=22",driver.findElement(By.cssSelector("div.d-block div.card-body p.card-text")).getText());
		Thread.sleep(2000);

		//for +-
		driver.get("http://localhost:" + port + "/math?param1=15&param2=-7&operator=minus");
		assertEquals("Result: -7-15=-22",driver.findElement(By.cssSelector("div.d-block div.card-body p.card-text")).getText());
		Thread.sleep(2000);

		driver.get("http://localhost:" + port + "/math?param1=183&param2=645&operator=minus");
		assertEquals("Result: 645-183=462",driver.findElement(By.cssSelector("div.d-block div.card-body p.card-text")).getText());
		Thread.sleep(2000);


		//Testing the parameter values
		driver.get("http://localhost:" + port + "/math?param1=50&param2=35.5&operator=plus");
		assertEquals("Param1 and/or Param2 are not real numbers.",driver.findElement(By.cssSelector("div.d-block div.card-body p.card-text")).getText());
		Thread.sleep(2000);

		driver.get("http://localhost:" + port + "/math?param1=mk&param2=yau&operator=plus");
		assertEquals("Param1 and/or Param2 are not real numbers.",driver.findElement(By.cssSelector("div.d-block div.card-body p.card-text")).getText());
		Thread.sleep(2000);

		driver.get("http://localhost:" + port + "/math?param1=''&param2=''&operator=plus");
		assertEquals("Param1 and/or Param2 are not real numbers.",driver.findElement(By.cssSelector("div.d-block div.card-body p.card-text")).getText());
		Thread.sleep(2000);

		driver.get("http://localhost:" + port + "/math?param1=50&param2=35.5&operator=minus");
		assertEquals("Param1 and/or Param2 are not real numbers.",driver.findElement(By.cssSelector("div.d-block div.card-body p.card-text")).getText());
		Thread.sleep(2000);

		driver.get("http://localhost:" + port + "/math?param1=50&param2=35.5&operator=minus");
		assertEquals("Param1 and/or Param2 are not real numbers.",driver.findElement(By.cssSelector("div.d-block div.card-body p.card-text")).getText());
		Thread.sleep(2000);

		driver.get("http://localhost:" + port + "/math?param1=''&param2=''&operator=minus");
		assertEquals("Param1 and/or Param2 are not real numbers.",driver.findElement(By.cssSelector("div.d-block div.card-body p.card-text")).getText());
		Thread.sleep(2000);

		//Testing against no operators
		driver.get("http://localhost:" + port + "/math?param1=100&param2=300&operator=");
		assertEquals("Invalid Operator was used. Try using 'plus' or 'minus'.",driver.findElement(By.cssSelector("div.d-block div.card-body p.card-text")).getText());
		Thread.sleep(2000);

		//Testing against plus and minus operators
		driver.get("http://localhost:" + port + "/math?param1=100&param2=300&operator=multiply");
		assertEquals("Invalid Operator was used. Try using 'plus' or 'minus'.",driver.findElement(By.cssSelector("div.d-block div.card-body p.card-text")).getText());
		Thread.sleep(2000);

		driver.get("http://localhost:" + port + "/math?param1=500&param2=5&operator=divide");
		assertEquals("Invalid Operator was used. Try using 'plus' or 'minus'.",driver.findElement(By.cssSelector("div.d-block div.card-body p.card-text")).getText());
		Thread.sleep(2000);

		//Testing against params
		driver.get("http://localhost:" + port + "/math?param1=25&value1=5&operator=plus");
		assertEquals("Missing query parameters. Please add all parameters: 'param1', 'param2', and 'operator'.",driver.findElement(By.cssSelector("div.d-block div.card-body p.card-text")).getText());
		Thread.sleep(2000);

		driver.get("http://localhost:" + port + "/math?value1=25&value2=5&operator=plus");
		assertEquals("Missing query parameters. Please add all parameters: 'param1', 'param2', and 'operator'.",driver.findElement(By.cssSelector("div.d-block div.card-body p.card-text")).getText());
		Thread.sleep(2000);
	}

	@Test
	public void testForm() throws InterruptedException{

		driver.get("http://localhost:" + port + "/index");
		assertEquals("Index - ENPM 614: Assignment 4", driver.getTitle());

		//testing the link
		WebElement el = driver.findElement(By.linkText("Form"));
		el.click();
		assertNotNull(el);

		//testing the form page title
		assertEquals("Form - ENPM 614: Assignment 4",driver.getTitle());

		List <WebElement> radiobtns  = driver.findElements(By.name("color"));
		int radioBtnSize=radiobtns.size();
		System.out.println("Size -------> " + radioBtnSize);
		List<String>colorValues= new ArrayList<String>();
		colorValues.add("red");
		colorValues.add("white");
		colorValues.add("blue");

		//iteration of the first color
		for(int i=0; i<radioBtnSize; i++){
			String colorValue=radiobtns.get(i).getAttribute("value");
			assertTrue(colorValues.contains(colorValue));
			//selecting blue color
			if(colorValue.equalsIgnoreCase("blue")){
				radiobtns.get(i).click();
				break;
			}
		}
		//setting Email ID
		WebElement email= driver.findElement(By.name("email"));
		email.sendKeys("madeniyi@umd.edu");


		//selecting I Agree
		WebElement agCheckbox= driver.findElement(By.name("isAgreed"));
		agCheckbox.sendKeys(Keys.SPACE);
		Thread.sleep(5000);

		WebElement submitBtn = driver.findElement(By.tagName("button"));
		submitBtn.submit();
		Thread.sleep(1000);

		//verifying email ID
		assertEquals("madeniyi@umd.edu",driver.findElement(By.name("email")).getAttribute("value"));

		//verifying color
		List<WebElement> submittedRadioBtns =driver.findElements(By.name("color"));
		String selectedColor = null;
		int submittedRadioBtnsLength = submittedRadioBtns.size();
				for(int i=0;i<submittedRadioBtnsLength; i++){
					String checked = submittedRadioBtns.get(i).getAttribute("checked");
					System.out.println("Checked ----> " + checked);
					if(checked!=null && checked.equalsIgnoreCase("true")){
						selectedColor = submittedRadioBtns.get(i).getAttribute("value");
					}
				}
		assertEquals("blue", selectedColor);

				//verifying isAgreed
		System.out.println(driver.findElement(By.name("isAgreed")).getAttribute("value"));
		assertEquals("on",driver.findElement(By.name("isAgreed")).getAttribute("value"));
	}

	@Test
	public void testFormAllEmpty() throws InterruptedException{
		driver.get("http://localhost:" + port + "/form?");
		assertEquals("Form - ENPM 614: Assignment 4", driver.getTitle());
		WebElement submitBtn = driver. findElement(By.tagName("button"));
		submitBtn.submit();

		assertEquals("Email must end with '@umd.edu'.", driver.findElement(By.xpath("/html/body/div/main/form/fieldset/fieldset[1]/div/p")).getText());
		assertEquals("You must pick a color.", driver.findElement(By.xpath("/html/body/div/main/form/fieldset/fieldset[2]/p")).getText());
		assertEquals("You must agree to submit form.", driver.findElement(By.xpath("/html/body/div/main/form/fieldset/fieldset[3]/div/p")).getText());
		Thread.sleep(5000);
	}


	@Test
	public void testEmailFormValidation() throws InterruptedException{
		driver.get("http://localhost:" + port + "/form?");
		assertEquals("Form - ENPM 614: Assignment 4", driver.getTitle());

		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("madeniyi@gmail.com");

		List<WebElement> submittedRadioBtns = driver.findElements(By.name("color"));
		submittedRadioBtns.get(1).click();

		WebElement agreeCheckBox = driver.findElement(By.name("isAgreed"));
		agreeCheckBox.sendKeys(Keys.SPACE);
		Thread.sleep(2000);

		WebElement submitBtn = driver.findElement(By.tagName("button"));
		submitBtn.submit();
		Thread.sleep(2000);
		assertEquals("Email must end with '@umd.edu'.", driver.findElement(By.xpath("/html/body/div/main/form/fieldset/fieldset[1]/div/p")).getText());
	}

	@Test
	public void testFormColorSelectionValidation() throws InterruptedException{
		driver.get("http://localhost:" + port + "/form?");
		assertEquals("Form - ENPM 614: Assignment 4", driver.getTitle());

		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("madeniyi@umd.edu");


		WebElement agreeCheckBox = driver.findElement(By.name("isAgreed"));
		agreeCheckBox.sendKeys(Keys.SPACE);
		Thread.sleep(2000);

		WebElement submitBtn = driver.findElement(By.tagName("button"));
		submitBtn.submit();
		Thread.sleep(2000);
		assertEquals("You must pick a color.", driver.findElement(By.xpath("/html/body/div/main/form/fieldset/fieldset[2]/p")).getText());
	}

	@Test
	public void testFormAgreementValidation() throws InterruptedException{

		driver.get("http://localhost:" + port + "/form?");
		assertEquals("Form - ENPM 614: Assignment 4", driver.getTitle());

		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("madeniyi@umd.edu");

		List<WebElement> submittedRadioBtns = driver.findElements(By.name("color"));
		submittedRadioBtns.get(1).click();
		Thread.sleep(1000);

		WebElement submitBtn = driver. findElement(By.tagName("button"));
		submitBtn.submit();
		assertEquals("You must agree to submit form.", driver.findElement(By.xpath("/html/body/div/main/form/fieldset/fieldset[3]/div/p")).getText());
		Thread.sleep(5000);
	}

	@Test
	public void testFormColorAndEmailValidation() throws InterruptedException{
		driver.get("http://localhost:" + port + "/form?");
		assertEquals("Form - ENPM 614: Assignment 4", driver.getTitle());

		WebElement agreeCheckBox = driver.findElement(By.name("isAgreed"));
		agreeCheckBox.sendKeys(Keys.SPACE);
		Thread.sleep(2000);

		WebElement submitBtn = driver. findElement(By.tagName("button"));
		submitBtn.submit();
		assertEquals("Email must end with '@umd.edu'.", driver.findElement(By.xpath("/html/body/div/main/form/fieldset/fieldset[1]/div/p")).getText());
		assertEquals("You must pick a color.", driver.findElement(By.xpath("/html/body/div/main/form/fieldset/fieldset[2]/p")).getText());
		Thread.sleep(5000);
	}

	@Test
	public void testFormAgreeAndEmailValidation() throws InterruptedException{
		driver.get("http://localhost:" + port + "/form?");
		assertEquals("Form - ENPM 614: Assignment 4", driver.getTitle());

		List<WebElement> submittedRadioBtns = driver.findElements(By.name("color"));
		submittedRadioBtns.get(1).click();
		Thread.sleep(2000);

		WebElement submitBtn = driver. findElement(By.tagName("button"));
		submitBtn.submit();
		assertEquals("Email must end with '@umd.edu'.", driver.findElement(By.xpath("/html/body/div/main/form/fieldset/fieldset[1]/div/p")).getText());
		assertEquals("You must agree to submit form.", driver.findElement(By.xpath("/html/body/div/main/form/fieldset/fieldset[3]/div/p")).getText());
		Thread.sleep(5000);
	}

	@Test
	public void testFormAgreeAndColorValidation() throws InterruptedException{
		driver.get("http://localhost:" + port + "/form?");
		assertEquals("Form - ENPM 614: Assignment 4", driver.getTitle());

		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("madeniyi@umd.edu");
		Thread.sleep(2000);

		WebElement submitBtn = driver. findElement(By.tagName("button"));
		submitBtn.submit();
		assertEquals("You must pick a color.", driver.findElement(By.xpath("/html/body/div/main/form/fieldset/fieldset[2]/p")).getText());
		assertEquals("You must agree to submit form.", driver.findElement(By.xpath("/html/body/div/main/form/fieldset/fieldset[3]/div/p")).getText());
		Thread.sleep(5000);
	}
}
