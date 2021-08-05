package com.perscholas.august3.student;
//for month: choose JAVA.TIME, not util.time
import com.perscholas.august3.student.repo.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){

        return args -> {
            Student Maria = new Student(
                    //remove id here
                    "Maria",
                    "maria.jam@gmail.com",
                    LocalDate.of(2000, JANUARY, 5)

            );
            Student Lily = new Student(
                    //remove id
                    "Lily",
                    "lily.jam@gmail.com",
                    LocalDate.of(2001, FEBRUARY, 5)

            );
            Student Ann = new Student(
                    //remove id
                    "Ann",
                    "ann.jam@gmail.com",
                    LocalDate.of(2002, MARCH, 8)
            );
            repository.saveAll(List.of(Maria, Lily, Ann));
        };
    }
}
