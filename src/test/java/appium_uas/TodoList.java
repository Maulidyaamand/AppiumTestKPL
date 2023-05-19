package appium_uas;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;



public class TodoList {
	
	static AppiumDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			startApp();
			addTodo();
			checkTodo();
		}catch(Exception exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}

	}
	
	public static void startApp() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Samsung A750GN");
        cap.setCapability("udid", "32006eb1c05995d1");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "10");
        
        cap.setCapability("appPackage", "todolist.scheduleplanner.dailyplanner.todo.reminders");
        cap.setCapability("appActivity", "app.todolist.activity.MainActivity");
        
        
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        
        //membuat objek driver
        driver = new AppiumDriver<MobileElement>(url, cap);
        
        
        System.out.println("Berhasil jalankan aplikasi..");
		
	}
	
	public static void addTodo() {
		
		//klik button add todo yang ada di pojok kanan bawah layar
		driver.findElementById("todolist.scheduleplanner."
				+ "dailyplanner.todo.reminders:id/wd").click();
		
		//jeda 1 detik
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		//mengetikkan todo
		driver.findElementById("todolist.scheduleplanner"
				+ ".dailyplanner.todo.reminders:id/ac5").sendKeys("buang sampah");
		
		//klik tombol simpan
		driver.findElementById("todolist.scheduleplanner"
				+ ".dailyplanner.todo.reminders:id/ac0").click();
		
		//jeda 3 detik
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        // Membuat objek TouchAction
        TouchAction touchAction = new TouchAction(driver);

        // Menentukan koordinat X dan Y yang ingin diklik
        int x = 879;
        int y = 1088;

        // Melakukan tap pada koordinat yang ditentukan
        touchAction.tap(PointOption.point(x, y)).perform();
        touchAction.tap(PointOption.point(x, y)).perform();
        touchAction.tap(PointOption.point(x, y)).perform();
		
	}
	
	public static void checkTodo() {
		//jeda 2 detik
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		//check todo
		driver.findElementById("todolist.scheduleplanner"
				+ ".dailyplanner.todo.reminders:id/abq").click();
		
	}

}
