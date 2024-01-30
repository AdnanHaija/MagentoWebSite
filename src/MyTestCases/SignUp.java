package MyTestCases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.checkerframework.checker.units.qual.radians;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUp extends Parameters {

	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void MySetup() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@Test(priority = 1)
	public void MyFirstTes() {
		driver.get("https://magento.softwaretestingboard.com/");

		driver.findElement(By.linkText("Create an Account")).click();

		WebElement FirstName = driver.findElement(By.id("firstname"));
		WebElement LastName = driver.findElement(By.id("lastname"));
		WebElement Email = driver.findElement(By.id("email_address"));
		WebElement Password = driver.findElement(By.id("password"));
		WebElement ConfirmPassword = driver.findElement(By.id("password-confirmation"));
		WebElement CreatAccountButton = driver.findElement(By.cssSelector("button[title='Create an Account'] span"));

		FirstName.sendKeys(FirstNames[RandomIndex]);
		LastName.sendKeys(LastNames[RandomIndex]);
		Email.sendKeys(EmailId);
		Password.sendKeys(CommonPassword);
		ConfirmPassword.sendKeys(CommonPassword);
		CreatAccountButton.click();

		String ActualSignUpWelcomeMsg = driver.findElement(By.className("message-success")).getText();

		assertEquals(ActualSignUpWelcomeMsg, "Thank you for registering with Main Website Store.");

	}

	@Test(priority = 2)
	public void LogOut() {
		driver.get("https://magento.softwaretestingboard.com/customer/account/logout/");

		assertEquals(driver.getCurrentUrl().contains("logoutSuccess"), true);

	}

	@Test(priority = 3)
	public void LogIn() throws InterruptedException {

		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys(EmailId);
		driver.findElement(By.id("pass")).sendKeys(CommonPassword);
		driver.findElement(By.id("send2")).click();

		Thread.sleep(2000);
		String ActualLogInWelcomeMsg = driver.findElement(By.cssSelector(".greet.welcome")).getText();
		assertEquals(ActualLogInWelcomeMsg.contains("Welcome"), true);

	}

	@Test(priority = 4)
	public void FooterTag() {
		WebElement Footer = driver.findElement(By.cssSelector(".footer.content"));
		int FooterTagsA = Footer.findElements(By.tagName("a")).size();

		System.out.println(FooterTagsA);

	}

	@Test(priority = 5)
	public void AddOneRandomItem() throws InterruptedException {
		driver.get("https://magento.softwaretestingboard.com/");
		WebElement HomePageItems = driver.findElement(By.cssSelector(".product-items.widget-product-grid"));
		int NumOfItems = HomePageItems.findElements(By.tagName("li")).size();
		System.out.println(NumOfItems);

		int RandomItemToSelect = rand.nextInt(4);
		HomePageItems.findElements(By.tagName("li")).get(RandomItemToSelect).click();

		WebElement SizesContainer = driver.findElement(By.cssSelector(".swatch-attribute.size"));
		int TheSizes = SizesContainer.findElements(By.className("swatch-option")).size();

		SizesContainer.findElements(By.className("swatch-option")).get(rand.nextInt(TheSizes)).click();

		WebElement ColorsContainer = driver.findElement(By.cssSelector(".swatch-attribute.color"));
		int TheColors = ColorsContainer.findElements(By.className("swatch-option")).size();

		ColorsContainer.findElements(By.className("swatch-option")).get(rand.nextInt(TheColors)).click();
		driver.findElement(By.id("product-addtocart-button")).click();
		Thread.sleep(3000);

		String ActualAddMsg = driver.findElement(By.cssSelector(".page.messages")).getText();

		assertEquals(ActualAddMsg.contains("You added"), true);

	}
}
