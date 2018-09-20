import entity.Serial;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import service.SerialService;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GetDocumentFromUrl {
    public static void main(String[] args) throws IOException {
        log.info("Application start");
        log.error("Error log start");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        SerialService serialService = context.getBean(SerialService.class);

        String url = "http://fanserials.care/";
        Connection connection = Jsoup.connect(url);
        connection.userAgent("Google Chrome/68.0.3440.106");
        Document doc = connection.get();
        String name = doc.title();
        System.out.println("Name of page html: " + name);

        //for rates
//        Elements div_rate = doc.select("div.rate");
//        Elements div_rate_kinogo = div_rate.select("div.kinogo");
//        Elements div_rate_imdb = div_rate.select("div.imdh");
//        for (Element rate: div_rate_kinogo) {
//            String rate_kinogo = rate.text();
//        }
        //for name
        Elements div = doc.select("div.literal");
        Elements ul = div.select("li>a");

        //for write to txt file
        //FileWriter writer = new FileWriter("D://fanserials/Serials.txt", false);

        List<String> filmNames = new ArrayList<>();

//        for (Element x : ul) {
//            //запись в бд
//            String name_rus = x.text();
//            filmNames.add(name_rus);
//            String link = x.attr("href");
//            Serial serial = new Serial();
//            serial.setNameRus(name_rus);
//            serial.setLink(link);
//            serialService.addSerial(serial);

//            System.out.println("\nСсылки " + x.attr("href") + " ------------------" + name_rus);
//            writer.write("{Ссылка: " + x.attr("href") + "," + "\n" + "Название: " + name_rus + "}");
//            writer.append('\n');
//            writer.flush();
//        }

        for (String filmName : filmNames) {
            System.out.println(filmName);
        }
        try{
            WebDriver firefoxDriver =  new FirefoxDriver();
            WebElement search_input = firefoxDriver.findElement(By.id("serial_search_input"));
            WebElement search_submit = firefoxDriver.findElement(By.className("ajax-inp-submit"));
            WebElement serial_info = firefoxDriver.findElement(By.className("item-search-header")).findElement(By.xpath("./h2/a"));

            for (String filmName : filmNames) {
                search_input.sendKeys(filmName);
                search_submit.click();
                serial_info.click();
                //место для сбора данных и записи в бд
            }
        }catch (Exception e){
            log.error("WebDriver connection false");
        }

    }
}


