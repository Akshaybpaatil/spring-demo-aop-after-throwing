package com.practice.springaop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.practice.springaop")
@EnableAspectJAutoProxy
public class AOPConfig {

}
