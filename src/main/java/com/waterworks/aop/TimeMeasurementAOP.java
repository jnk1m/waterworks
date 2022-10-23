package com.waterworks.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Aspect
@Component
public class TimeMeasurementAOP {
   @Around("execution(* com.waterworks..*.*(..))")
   private Object logging(ProceedingJoinPoint pjp) throws IOException {
      StopWatch stopWatch = new StopWatch();
      String methodName = null;

      File methodCallTimeLog = new File("src/main/java/com/waterworks/aop/elapse.log");
      if (!methodCallTimeLog.exists()) {
         methodCallTimeLog.createNewFile();
      }
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(methodCallTimeLog, true));
      try {
         stopWatch.start();
         methodName = pjp.getSignature().getName();
         bufferedWriter.write(methodName + " ");
         Object retVal = pjp.proceed();
         return retVal;

      } catch (Throwable e) {
         throw new RuntimeException(e);
      } finally {
         stopWatch.stop();
         String totalTimeMillis = String.valueOf(stopWatch.getTotalTimeMillis());

         bufferedWriter.write(totalTimeMillis + "[ms]\n");
         bufferedWriter.close();
      }
   }
}
