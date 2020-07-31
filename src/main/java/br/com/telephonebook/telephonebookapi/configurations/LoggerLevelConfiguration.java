package br.com.telephonebook.telephonebookapi.configurations;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggerLevelConfiguration {

    @Bean
    Logger.Level feignLoLevel(){
        return Logger.Level.FULL;
    }
}
