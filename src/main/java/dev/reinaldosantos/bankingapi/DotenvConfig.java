package dev.reinaldosantos.bankingapi;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.StandardEnvironment;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DotenvConfig {
    
    @Bean
    public Dotenv dotenv() {
        return Dotenv.load();
    }
    
    @Bean
    public Environment environment(Dotenv dotenv) {
        StandardEnvironment environment = new StandardEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        
        Map<String, Object> map = new HashMap<>();
        dotenv.entries().forEach(entry -> map.put(entry.getKey(), entry.getValue()));
        
        propertySources.addLast(new MapPropertySource("dotenvProperties", map));
        return environment;
    }
}