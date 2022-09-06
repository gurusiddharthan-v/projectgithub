package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
		
		public static WebDriver driver;
		
	//Brower launch if condition
		
	    public static  WebDriver browerLaunch(String browername) {
			if(browername.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if(browername.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else if(browername.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			return driver;
	       
			
		}
		
	//Brower launch swith case
		
		public static WebDriver browerLaunch1(String browername) {
	      switch (browername) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
		    WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			System.err.println("invalid browers");
		}
		return driver;
	  
		}
		
	//Brower launch
		
		public static WebDriver chromeBrower() {
			WebDriverManager.chromedriver().setup();
		    return driver = new ChromeDriver();	
		}
		public static WebDriver firefoxBrower() {
			WebDriverManager.firefoxdriver().setup();
		    return driver = new FirefoxDriver();	
		}
		public static WebDriver edgeBrower() {
			WebDriverManager.edgedriver().setup();
		    return driver = new EdgeDriver();	
		}

	// URL Launch
		
		public static void urlLaunch(String url) {
			driver.get(url);
			driver.manage().window().maximize();
		}
		
//		Dynamic wait
		public static void implicitywait(long sec) {
			driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
		}
		
	// Static wait
		public static void threadSleep(long millis) throws InterruptedException {
	        Thread.sleep(millis);
		}
		
	// click	
		public static void click(WebElement c) {
			c.click();	
		}

	// SendKeys 	
		public static void sendkeys(WebElement e, String value) {
	        e.sendKeys(value);		
		}
		
	//Submit	
		public static void submit(WebElement s) {
			s.submit();
		}

	//Get Current URL
		public static String currenUrl() {
		   String uRl = driver.getCurrentUrl();
		   return uRl;
		}

	//GetTitle 	
		public static String title() {
	       String title = driver.getTitle();
		   return title;
		}
		
	//GetAttribute	
		public static String getAttribute(WebElement e) {
			String att = e.getAttribute("value");
			return att;  
		}

	//GetText
		public static String getText(WebElement e) {
			String text = e.getText();
			return text;
		}

	//Action	
	//Get MoveToElement
		public static void moveToElement(WebElement e) {
			Actions a = new Actions(driver);
			a.moveToElement(e).perform();
		}

	//DragAndDrop
		public static void dragAndDrop( WebElement source ,WebElement target) {
			Actions a = new Actions(driver);
			a.dragAndDrop(source, target).perform();   
		}
		
	//ClickandHold
		public static void clickAndHold( WebElement source , WebElement target ) {
			Actions a = new Actions(driver);
			a.clickAndHold(source).release(target).perform();        
		}
		
	//rightclick
		public static void rightClick(WebElement e) {
			Actions a = new Actions(driver);
			a.contextClick(e).perform();
		}

	//DoubleClick
		public static void doubleClick(WebElement e) {
			Actions a = new Actions(driver);
			a.doubleClick(e).perform();
		}

	//clear
		public static  void clear(WebElement e) {
	       e.clear();
		}
		
	//selectByIndex	
		public static Select selectByIndex(WebElement e, int index) {
	       Select s = new  Select(e);
	       s.selectByIndex(index);
		return s;
		}

	//selectByValue
		public static  Select selectByValue(WebElement e, String value) {
			Select s = new Select(e);
			s.selectByValue(value);
			return s;
		}

	//selectbyText	
		public static  Select selectbyText(WebElement e, String value ) {
			Select s = new Select(e);
	        s.selectByVisibleText(value);
			return s;
		}
		
	//TakeScreenShotAs
		public static void ScreenShot(String name) throws IOException {
			TakesScreenshot tk = (TakesScreenshot)driver;
			File src = tk.getScreenshotAs(OutputType.FILE);
			File des = new File(System.getProperty("user+dir")+"\\src\\test\\resources\\Screenshot\\"+name+".png");
			FileUtils.copyDirectory(src,des );
	           
		}
		
		public static void js(String name, WebElement e) {
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
	        js.executeScript("argument[0].setAttribute('value','"+name+"')",e);
		}
		
	//FirstSelectedoption
		public static void firstSelectedOption(WebElement e) {
	       Select s = new Select(e);
	       s.getFirstSelectedOption();
		}
		
	//Deselectoptionbyindex
		public static void deselectedindex(WebElement e, int index) {
	       Select s = new Select(e);
	       s.deselectByIndex(index);
		}

	//Deselectoptionbyvalue
		public static void deSelectedByValue(WebElement e, String value) {
			Select s = new Select(e);
			s.deselectByValue(value);  
		}

	//DeselectoptionByText
		public static void deSelectaoptionByText(WebElement e, String value) {
			Select s = new Select(e);
			s.deselectByVisibleText(value);
		}

	//DeselectAll
		public static void deSelectAll(WebElement e) {
			Select s = new Select(e);
			s.deselectAll();    
		}

	//Switch to frame index
		public static void frameIndex(int index) {
	         driver.switchTo().frame(index);
		}

	//Switch to frame name
		public static void frameName( String nameOrId) {
	       driver.switchTo().frame(nameOrId);
		}

	//Switch to frame Element
		public static void frameElement(WebElement frameElement) {
	       driver.switchTo().frame(frameElement);
		}

	//switch out from Frame
		public static void frameOut() {
	       driver.switchTo().defaultContent();
		}

	//switch out from Frame one by one
		public static void parentframe() {
	      driver.switchTo().parentFrame();
		}
		
	//Window Handle
		public static String parentId() {
	       String Locatorname = driver.getWindowHandle();
		return Locatorname;
	       
		}
		
	//Window Handles
		public static Set<String> allIds() {
	       Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
		}

	//WindowsHandling
		public static void windowsHandling() {
	          String parentId = driver.getWindowHandle();
	          Set<String> allIds = driver.getWindowHandles();
	          for(String eachId:allIds) {
	        	  if(!parentId.equals(eachId)) {
	        		  driver.switchTo().window(eachId);
	        	  }
	          }
		}
		
	//navigate refresh
		public static void navigateRefresh() {
	         driver.navigate().refresh();
		}
		
	//navigateBack
		public static void navigateBack() {
	        driver.navigate().back();
		}
		
//		navigateForward
		public static void navigateForward() {
	       driver.navigate().forward();
		}
		
	//Alert
		public static Alert alert() {
	       Alert a = driver.switchTo().alert();
		return a;
		}
		
	// accept Alert
		public static Alert alertAccept() {
	        Alert a = driver.switchTo().alert();
	        a.accept();
			return a;
		}
		
	// dismiss Alert	
		public static Alert alertDismiss() {
	        Alert a = driver.switchTo().alert();
	        a.dismiss();
			return a;
		}
		
	//scrollup
		public static void scrollUp(WebElement e) {
	       JavascriptExecutor js = (JavascriptExecutor)driver;
	       js.executeScript("argument[0].scrollIntoView(flase)",e);
		}

	//scrolldown
		public static void scrollDrow(WebElement e) {
		       JavascriptExecutor js = (JavascriptExecutor)driver;
		       js.executeScript("argument[0].scrollIntoView(true)",e);
		}
		
	//Excelread
		public static String getExcel(String excelName,String SheetName,int rowNo,int cellNo) throws IOException {
			
		    //File
			 File f = new File("C:\\Users\\GURUSIDDHARTHAN\\eclipse-workspace\\TestNg_10_12_2022\\src\\test\\resources\\"+excelName+".xlsx");
			 //Fileinputstream
			 FileInputStream fi = new FileInputStream(f);
			 //WorkBook 
			 Workbook w = new XSSFWorkbook(fi);
			 //sheet
			 Sheet s = w.getSheet(SheetName);
			 //Row
			 Row r = s.getRow(rowNo);
	         //cell
			 Cell c = r.getCell(cellNo);
		     //type1---->string(name)
	      	//type0----->numbers,date	 
			 int cellType = c.getCellType();	 	 
		     String value=null ;
		     if(cellType==1) {
			 value = c.getStringCellValue();
	         	}
	      	else {
		    	if (DateUtil.isCellDateFormatted(c)) {
				Date dateCellValue = c.getDateCellValue();
				SimpleDateFormat  sim = new SimpleDateFormat("dd-MM-yyyy");
				 value = sim.format(dateCellValue);		}
		    	else {
				double numericCellValue = c.getNumericCellValue();
				long lo = (long)numericCellValue;
				 value = String.valueOf(lo);
		     	}
	       	}
	    	return value ;
			
	        
		}
	}


