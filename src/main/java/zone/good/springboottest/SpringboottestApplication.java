package zone.good.springboottest;

import org.hibernate.annotations.Filter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import zone.good.springboottest.formatter.ClassroomFormatter;
import zone.good.springboottest.service.ClassRoomService;
import zone.good.springboottest.service.ClassRoomServiceImpl;
import zone.good.springboottest.service.StudentService;
import zone.good.springboottest.service.StudentServiceImpl;

import javax.servlet.annotation.WebFilter;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableConfigurationProperties
@EnableWebMvc
@EnableTransactionManagement
@EnableJpaRepositories("zone.good.springboottest.repository")
@ComponentScan("zone.good.springboottest.Controller")

public class SpringboottestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringboottestApplication.class, args);
    }
    @Bean
    public ClassRoomService classRoomService(){
        return new ClassRoomServiceImpl();
    }
    @Bean
    public StudentService studentService(){ return  new StudentServiceImpl();
    }
}
