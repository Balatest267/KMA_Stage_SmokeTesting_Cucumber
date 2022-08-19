package stepDefinitions;

import java.awt.List;
import java.util.*;

import org.apache.http.util.Asserts;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProdSmokeTestingSD {

		WebDriver driver;
		WebDriverWait objWait;
	
	
	@Given("^user is on KIA web portal Landing Page$")
	public void user_is_on_KIA_web_portal_Landing_Page() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://sweb.owners.kia.us/us/en/kia-owner-portal.html");
	}
	    

	@And("^page title is Kia Owners Portal$")
	public void page_title_is_Kia_Owners_Portal() {
		String dpTitle= driver.getTitle();
		//Reporter.log("Landing Page Title is = "+dpTitle);
		System.out.println("Landing Page Title is = "+dpTitle);
		Assert.assertEquals("Kia Owners Portal", dpTitle);
	}
	

	@And("^user clicks the Sign in button$")
	public void user_clicks_the_Sign_in_button() throws InterruptedException {
		driver.findElement(By.xpath("(//*[contains(text(),'SIGN IN')])[1]")).click();
		Thread.sleep(10000);
		//Reporter.log("Clicks Sign-In Button - Success");
		System.out.println("Clicks Sign-In Button - Success");
	}

	
	@When("^user enter the \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enter_the_username_and_password(String username, String password) {
		driver.findElement(By.name("userLoginId")).sendKeys(username);
		driver.findElement(By.name("userLoginPwd")).sendKeys(password);
	}
	

	@And("^user clicks the login button$")
	public void user_clicks_the_login_button() throws InterruptedException {
		driver.findElement(By.xpath("//*[contains(text(),'          Sign In ')]")).click();
		//Reporter.log("Clicks Login Button - Success");
		System.out.println("Clicks Login Button - Success");
		Thread.sleep(30000);
	}

	

	
	@Then("^user is on welcome page$")
	public void user_is_on_welcome_page() throws InterruptedException {
		String welpgTitle= driver.getTitle();
		System.out.println("Welcome Page Title is = "+welpgTitle);
		Assert.assertEquals("Welcome", welpgTitle);
		Thread.sleep(20000);
	}
	
	
	
	@Then("^user pick the vehicle$")
	public void user_pick_the_vehicle() throws InterruptedException  {
	java.util.List<WebElement> vehList = driver.findElements(By.xpath("//*[@class='my-vehicles-grid-item-header']/strong"));
	int totalNumVehicles = vehList.size();
	System.out.println("Total Number of Vehicles are = " + totalNumVehicles);
	
	for (WebElement vehlst : vehList) {
		String totVehlst = vehlst.getText().trim();
		System.out.println("Total number of vehicles in this account = " + totVehlst);
		if(totVehlst.equalsIgnoreCase("EV6-253")){
			
			WebElement ele = driver.findElement(By.xpath("(//*[@title='EV6'])[1]")); 
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click()", ele);			
			break;	
		} else {
			System.out.println("No Such Vehicles Found In This Account");
		}
		Thread.sleep(20000);
	}
}
	

	//--------------------------------------------Dashboard-------------------------------------
	
	
	@Then("^user is on dashboard page$")
	public void user_is_on_dashboard_page() throws Throwable {
		 String dpTitle = driver.getTitle();
		    System.out.println("Dashboard Page Title is = "+dpTitle);
		    //Assert.assertEquals("Welcome", dpTitle);
		    
		    if(dpTitle.equalsIgnoreCase("Dashboard")) {
		    	System.out.println("Üser is in " + dpTitle + " page");
		    } else {
		    	System.out.println("User is not in welcome page");
		    }
		    Thread.sleep(20000);
	}

	
	@Then("^fetch the name of the vehicle$")
	public void fetch_the_name_of_the_vehicle() throws InterruptedException  {
		String vehName = driver.findElement(By.xpath("(//span[@class='title'])[2]")).getText();
		System.out.println("Model of the vehicle is = "+vehName);
		Thread.sleep(10000);
	} 
	
/*
	@Then("^get the status of the door$")
	public void get_the_status_of_the_door() throws InterruptedException  {
	   //String rdStatus = driver.findElement(By.xpath("//*[@class='state-1 active']")).getText();
		String rdStatus = driver.findElement(By.xpath("(//span[@class='state-1 active'])[1]")).getText();
	   System.out.println("Currently vehicle is " + rdStatus +" status ");
	   Thread.sleep(20000);
	}
	
	

	@Then("^user clicks the lockUnlock option$")
	public void user_clicks_the_lockUnlock_option() throws InterruptedException  {
		 		
			for (int i = 0; i <=1; i++) {
			 	String rdStatus = driver.findElement(By.xpath("(//span[@class='state-1 active'])[1]")).getText();
				if (rdStatus.equalsIgnoreCase("DOORS ARE LOCKED")) {
					WebElement ele1 = driver.findElement(By.xpath("//span[@class='action-button state-1 btn-unlock']"));
					JavascriptExecutor jse = (JavascriptExecutor)driver;
					jse.executeScript("arguments[0].click()", ele1);
				} else if(rdStatus.equalsIgnoreCase("DOORS ARE UNLOCKED")) {
					WebElement ele2 =driver.findElement(By.xpath("//span[@class='action-button state-2 btn-lock']"));
					JavascriptExecutor jse = (JavascriptExecutor)driver;
					jse.executeScript("arguments[0].click()", ele2);
				} 
				Thread.sleep(60000);
				
				String rdCurStatus = driver.findElement(By.xpath("(//span[@class='state-1 active'])[1]")).getText();
				System.out.println("After performing the remote action, vehicle is = "+ rdCurStatus + " Status");
				Thread.sleep(20000);
						
				//java.util.List<WebElement> notiMsg = driver.findElements(By.xpath("//div[@class='alerts']"));
				java.util.List<WebElement> notiMsg = driver.findElements(By.xpath("//div[@class='alerts']/div/p"));
				for (WebElement altMsg : notiMsg) {
					String alertsMsg = altMsg.getText().trim();
				
					Thread.sleep(10000);
			
					if(alertsMsg.equalsIgnoreCase("The remote command for unlock executed successfully.")) {
					 System.out.println("Remote Actions Alert Message is = "+alertsMsg +" - Success");
					 //driver.findElement(By.xpath("//button[@class='close']")).click();
				 } else if(alertsMsg.equalsIgnoreCase("The remote command for lock executed successfully.")) {
					 System.out.println("Remote Actions Alert Message is = "+alertsMsg +" - Success");
					 //driver.findElement(By.xpath("//button[@class='close']")).click();
				 } else if (alertsMsg.equalsIgnoreCase("alert alert-failed alert-dismissible")) {
					 System.out.println("Remote Actions Alert Message is = "+alertsMsg +" - Fail");
					 //driver.findElement(By.xpath("//button[@class='close']")).click();
				 } else if(alertsMsg.equalsIgnoreCase("We cannot process your request. Please verify that your vehicle's doors, hood, and trunk are closed and locked")) {
					 System.out.println("Remote Actions Alert Message is = "+alertsMsg +" - Another request inprogress"); 
					 //driver.findElement(By.xpath("//button[@class='close']")).click();
				  
				} 
					 else if(alertsMsg.equalsIgnoreCase(null)) { 
						 System.out.println("Blank Notification Displayed");
					 }
					  //driver.findElement(By.xpath("//button[@class='close']")).click(); }
					 
				}
				 Thread.sleep(10000);
			}
	}
	
	*/
	
	

	/*
	
	@Then("^user clicks the remoteClimate option$")
	public void user_clicks_the_remoteClimate_start_option() throws InterruptedException {
		
		
			String rdCliStatus = driver.findElement(By.xpath("//*[contains(text(),'Set Your Climate')]")).getText();
			System.out.println("Current Actions is = "+ rdCliStatus);
			
			
								
				for (int i = 0; i <=1; i++) {
					driver.findElement(By.xpath("//span[@class='action-button active btn-climate']")).click();
					Thread.sleep(10000);
					
					String cliStat = null;
					try {
						
						//driver.findElement(By.xpath("//span[@class='up']")).click();
						 
						
						//WebElement ddValue = driver.findElement(By.id("select2-s0gs-container"));
						//Select durationDD = new Select(ddValue); 
						//durationDD.deselectByIndex(5);
						
						//driver.findElement(By.xpath("(//span[@class='toggle'])[1]")).click();
						//driver.findElement(By.xpath("(//span[@class='toggle'])[2]")).click();
						//--Comment
						
						cliStat = driver.findElement(By.xpath("//*[contains(text(),' Start Climate')]")).getText().trim();
						System.out.println("Remote Action Current status is ="+cliStat);
						
					} catch (Exception e) {			
						
					}
					
					if(cliStat!=null) {
						
						//if (cliStat.equalsIgnoreCase("START CLIMATE")) {
							
						driver.findElement(By.xpath("//*[contains(text(),' Start Climate')]")).click();
						Thread.sleep(20000);
						driver.findElement(By.id("ventilation-warning-okbtn")).click();
						Thread.sleep(40000);
						System.out.println("Remote Climate - Start");
						} else {
							Thread.sleep(20000);
							driver.findElement(By.xpath("//button[@class='button main']")).click();
							System.out.println("Remote Climate - Stop");
						}
						
						Thread.sleep(20000);
					
			
			  //driver.findElement(By.xpath("//button[@class='close']")).click();
			  
			// Thread.sleep(30000);
			 
				}
				Thread.sleep(20000);
		}
	*/
	
	/*
	@Given("^user is on Remote Section$")
	public void user_is_on_Remote_Section() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[@href=\"/content/owners/en/remote.html?page=security\"]")).click();
		Thread.sleep(20000);
		
		String rpTitle = driver.getTitle();
	    System.out.println("Page Title is = "+rpTitle);
	    //Assert.assertEquals("Welcome", dpTitle);
	    
	    if(rpTitle.equalsIgnoreCase("Remote")) {
	    	System.out.println("Üser is in " + rpTitle + " page");
	    } else {
	    	System.out.println("User is not in Remote page");
	    }
	    Thread.sleep(20000);
		
	}
	
	
		
	@Given("^user is on Schedules Section$")
	public void user_is_on_Schedule_Section() throws InterruptedException {
		
		driver.findElement(By.xpath("//i[@class='icon-schedules']")).click();
		Thread.sleep(20000);
		
		String spTitle = driver.getTitle();
	    System.out.println("Page Title is = "+spTitle);
	    //Assert.assertEquals("Welcome", dpTitle);
	    
	    if(spTitle.equalsIgnoreCase("Schedules")) {
	    	System.out.println("Üser is in " + spTitle + " page");
	    } else {
	    	System.out.println("User is not in Schedule page");
	    }
	    Thread.sleep(20000);
		
	}
	
	
	@Given("^user is on Locations Section$")
	public void user_is_on_Locations_Section() throws InterruptedException {
		
		driver.findElement(By.xpath("//i[@class='icon-locations']")).click();
		Thread.sleep(20000);
		
		String spTitle = driver.getTitle();
	    System.out.println("Page Title is = "+spTitle);
	    //Assert.assertEquals("Welcome", dpTitle);
	    
	    if(spTitle.equalsIgnoreCase("Locations")) {
	    	System.out.println("Üser is in " + spTitle + " page");
	    } else {
	    	System.out.println("User is not in Location page");
	    }
	    Thread.sleep(20000);
		
	}
	
	
	@Given("^user is on Maintenance Section$")
	public void user_is_on_Maintenance_Section() throws InterruptedException {
		
		driver.findElement(By.xpath("(//i[@class='icon-maintence'])[1]")).click();
		Thread.sleep(20000);
		
		String spTitle = driver.getTitle();
	    System.out.println("Page Title is = "+spTitle);
	    //Assert.assertEquals("Welcome", dpTitle);
	    
	    if(spTitle.equalsIgnoreCase("Maintenance")) {
	    	System.out.println("Üser is in " + spTitle + " page");
	    } else {
	    	System.out.println("User is not in Maintenance page");
	    }
	    Thread.sleep(20000);
		
	}
	
	
	@Given("^user is on MyCarZone Section$")
	public void user_is_on_MyCarZone_Section() throws InterruptedException {
		
		driver.findElement(By.xpath("(//i[@class='icon-mycarzone'])[1]")).click();
		Thread.sleep(20000);
		
		String spTitle = driver.getTitle();
	    System.out.println("Page Title is = "+spTitle);
	    //Assert.assertEquals("Welcome", dpTitle);
	    
	    if(spTitle.equalsIgnoreCase("My Car Zone")) {
	    	System.out.println("Üser is in " + spTitle + " page");
	    } else {
	    	System.out.println("User is not in MyCarZone page");
	    }
	    Thread.sleep(20000);
		
	}
	
	
	
	  /*@Then("^user find the vehicle location$") 
	  public void user_find_the_vehicle_location() throws InterruptedException {
	  driver.findElement(By.xpath("//i[@class='icon-locations']")).click();
	  Thread.sleep(60000);
	  Boolean vehLocation =  driver.findElement(By.xpath("//img[@src='/content/dam/kia/us/owners/image/feature/locations/pin_car.png']")).isDisplayed();
	  System.out.println("Vehicle is Displayed");
	  String vehLoc = driver.findElement(By.xpath("//div[@class='pin-data']")).getText();
	  System.out.println("Vehicle Located at : "+vehLoc);
	
	  
	  }*/
	 
	  
	  
	
	 @Then("^close the browser$") 
	 public void close_the_browser() {
		 
	 driver.close(); System.out.println("Browser Closed - Success"); 
	 }
	 
	 
	 
	 
	 //-------------------------------------------------------------------------
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 /*@Then("^Send Mail to the Defined Users$")
	 public void Sending_Mail() {
		 
		 try
		    {
		      //Get client name from configuration.
		      prop = ObjRepo.objRepositryLoad(propFilePath);
		      //String toemailid = prop.getProperty("TO_MAIL_ADDRESS");
		      String emailbodytxt = prop.getProperty("MAIL_BODYMESSAGE");
		      String subject = prop.getProperty("MAIL_SUBJECT")+" @ "+dateTime("MailTime");
		      String mail_fromAddrsHeader = "Automation Report (-NoReply-)";
		      String mail_fromAddrs = prop.getProperty("FROM_MAIL_ADDRESS");
		      String mail_rplyTo = prop.getProperty("REPLYTO_MAIL_ADDRESS");
		      String mail_ccAddrs = prop.getProperty("CC_MAIL_ADDRESS");	
		                
		      String smtpHostServer = "outlook.hyundai.net";
		      
		      String toEmail = toemailid.trim(); 
		      Properties props = System.getProperties();
		      props.put("mail.smtp.host", smtpHostServer);
		      Session session = Session.getInstance(props, null);
		      MimeMessage msg = new MimeMessage(session);
		      
		      //set message headers
		      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
		      msg.addHeader("format", "flowed");
		      msg.addHeader("Content-Transfer-Encoding", "8bit");
		      
		      //String filename = genericMethods.getRootFolder()+"\\test-output\\html\\index.html";//prop.getProperty("emailAttach");
		      //String filename = genericMethods.getRootFolder()+"\\HTML_Report_25_02_2019_03_22_53.zip";
		      //System.out.println(filename);
		      //DataSource source = new FileDataSource(filename);
		      //msg.setDataHandler(new DataHandler(source));
		      
		      //msg.setFileName(filename);
		      //msg.setFileName (new File(filename).getName());
		      msg.setFrom(new InternetAddress(mail_fromAddrs, mail_fromAddrsHeader));
		      msg.setReplyTo(InternetAddress.parse(mail_rplyTo, false));
		      msg.setSubject(subject, "UTF-8");
		      
		      // Set the email msg text.
			  MimeBodyPart messagePart = new MimeBodyPart();
			  //messagePart.setText("Team,"+"\n\n"+emailbodytxt.trim()+"\n\n"+"Thanks,"+"\n"+"Automation Team.");
			  messagePart.setContent("<!DOCTYPE html>" + 
			  		"<html>" +
					  "<head>" + 
					  "<style>" + 
					  "table, th, td {" + 
					  "  border: 1px solid black;" + 
					  "  border-collapse: collapse;" + 
					  "}" + 
					  "</style>" + 
					  "</head>"+
			  		"<body>" +
			  		"<h2 align='left' style=\"color:DodgerBlue;\">"+subject+"</h2>" +//@ "+dateTime("MailTime")
			  		"<p>"+emailbodytxt.trim()+"</p>"+
			  		"<table style=\"width:25%\">" + 
			  		"  <tr>" + 
			  		"    <th>WebsiteName</th>" +
			  		"    <th>Status</th>" + 
			  		//"    <th>Remarks</th>" + 
			  		"  </tr>" +dynamicRows(testcaseNo)+
			  		"</table>" + 
			  		"<p>Thanks, <br>Automation Team.</p>"+
			  		"</body>\r\n" + 
			  		"</html>", "text/html; charset=utf-8");
			  
			  //FileDataSource fileDataSource = new FileDataSource(filename);
			
			  //MimeBodyPart attachmentPart = new MimeBodyPart();
			  //attachmentPart.setDataHandler(new DataHandler(fileDataSource));
			  //attachmentPart.setFileName(fileDataSource.getName());
			  
			  // Create Multipart E-Mail.
			  Multipart multipart = new MimeMultipart();
			  multipart.addBodyPart(messagePart);
			  //multipart.addBodyPart(attachmentPart);
			  
			  msg.setContent(multipart);

		      //msg.setText(body, "UTF-8");

		      msg.setSentDate(new Date());
		      System.out.println("Preparing to Send Mail...");

		      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
		      msg.addRecipients(Message.RecipientType.CC, InternetAddress.parse(mail_ccAddrs, false));//new InternetAddress(mail_ccAddrs));	
		      
		      Transport.send(msg); 
		      
		      System.out.println("EMail Sent Successfully!!");
		      Log.info("EMail Sent Successfully!!");
		      Thread.sleep(3000);
		      if(testcaseNo.equalsIgnoreCase(prop.getProperty("_TC_NUMB_TOVALIDATE")))
		      {
		    	  ovrAllStats.clear();
		      }
		      ResultStats.clear();
		      rowcount=0;
		    }
		    catch (Exception e)
			{
		    	System.out.println("Exception @sendMail function: "+e.getMessage());
				Log.debug("Exception @sendMail function: "+e.getMessage());
		    	e.printStackTrace();
		    	ResultStats.clear();
		    	ovrAllStats.clear();
		    	rowcount=0;
		    }
		 }*/
	 
}	
	























