package com.waterworks.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.waterworks")
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class WaterWorkConfig {
}
