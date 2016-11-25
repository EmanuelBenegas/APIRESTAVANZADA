package Apirest;

import Apirest.conversores.UsuarioConversor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lcc on 22/11/2016.
 */
@Configuration
public class Configuracion {
    @Autowired
    AuthFilter authFilter;

    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(authFilter);
        registration.addUrlPatterns("/api/*");
        return registration;
    }
}
