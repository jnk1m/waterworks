import com.waterworks.billing.BillingRepository;
import com.waterworks.config.WaterWorkConfig;
import com.waterworks.parser.DataParser;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.PriorityQueue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WaterWorkConfig.class})
public class BillingRepositoryTest {
   static BillingRepository billingRepository;
   static DataParser dataParser;

   @BeforeAll
   public static void init() {
      ApplicationContext applicationContext = new AnnotationConfigApplicationContext(WaterWorkConfig.class);
      billingRepository = applicationContext.getBean(BillingRepository.class);
      dataParser = applicationContext.getBean(DataParser.class);
   }

   @Test
   public void loadRateQueueTest(){
      String path = "src/test/resources/Tariff_20220331.csv";
      dataParser.parseCsvToQueue(path);

      PriorityQueue<String[]> strings = billingRepository.loadRateQueue(path);

      Assertions.assertThat(strings).isNotEmpty();
   }

   @Test
   public void getFiveCheapestRate(){
      //정렬된 데이터 열개를 주면 다섯개만 뽑아서 주는지


      billingRepository.getFiveCheapestRate(1000);

   }


}
