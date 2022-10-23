import com.waterworks.config.WaterWorkConfig;
import com.waterworks.parser.DataParser;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.PriorityQueue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WaterWorkConfig.class})
public class DataParseTest {
   static DataParser dataParser;

   @Test
   public void parseCsvToQueueTest() throws NoSuchFieldException {
      ApplicationContext applicationContext = new AnnotationConfigApplicationContext(WaterWorkConfig.class);
      dataParser = applicationContext.getBean(DataParser.class);

      String path = "src/test/resources/Tariff_20220331.csv";

      PriorityQueue<String[]> strings = dataParser.parseCsvToQueue(path);

      Assertions.assertThat(strings).isNotEmpty();
   }
}
