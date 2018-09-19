import entity.Serial;
import lombok.extern.slf4j.Slf4j;
import service.SerialService;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileWriter;
import java.io.IOException;

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

        Elements div = doc.select("div.literal");
        Elements ul = div.select("li>a");

         FileWriter writer = new FileWriter("D://fanserials/Serials.txt", false);

        for (Element x : ul) {
            //запись в бд
            String name_rus = x.text();
//            String link = x.attr("href");
//            Serial serial = new Serial();
//            serial.setName_rus(name_rus);
//            serial.setLink(link);
//            serialService.addSerial(serial);

            System.out.println("\nСсылки " + x.attr("href") + " ------------------" + name_rus);
            writer.write("{Ссылка: " + x.attr("href") + "," + "\n" + "Название: " + name_rus + "}");
            writer.append('\n');
            writer.flush();
        }
    }
}


