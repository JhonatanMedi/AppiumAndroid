package MobilesAppium.appiumtest;

import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import TiempoEspera.Espera;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class aplicacionMovil {
	
	static AppiumDriver<MobileElement> driver;
	private static Espera TiemEspera = new Espera();
	
	public static void main(String[] arg) {
try {
	abrirAplicacion();
} catch (Exception e) {
	System.out.println(e.getCause());
	System.out.println(e.getMessage());
	e.printStackTrace();
}
		
	}

	public static void abrirAplicacion() throws Exception {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "vivo 1935"); // Nombre dispositivo que van colocar
		cap.setCapability("udid", "50bb9d01");//nombre de dispotivo al hacer comando "adb devices"
		cap.setCapability("platformName", "Android");// sistema operativo 
		cap.setCapability("platformVersion", "11");// version del android
		cap.setCapability("appPackage", "com.google.android.youtube"); //aplicacion donde va ingresar
		cap.setCapability("appActivity", "com.google.android.apps.youtube.app.WatchWhileActivity");// el inicio de la pagina

		URL url = new URL("http://127.0.0.1:4723/wd/hub");// esto es por defecto que siempre se va utilizar
		driver = new AppiumDriver<MobileElement>(url, cap);
		System.out.println("Iniciando aplicacion"); //imprimimos para saber que se ejecuto
		
		TiemEspera.segundos(6);
		MobileElement btnBuscar = driver.findElement(By.id("com.google.android.youtube:id/menu_item_1"));
		btnBuscar.click();

		TiemEspera.segundos(3);
		MobileElement texto = driver.findElement(By.id("com.google.android.youtube:id/search_edit_text"));
		texto.click();
		TiemEspera.segundos(3);
		texto.sendKeys("Twenty one pilot");
		
	}
}
