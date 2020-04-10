package ua.lviv.lgs.homework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class StudentConfig {

    @Scope("singleton")
    @Bean(name = "studentDao")
    public StudentDao getStudentDao(){
        return new StudentDao();
    }

}
