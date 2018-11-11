package com.jpa.experiments.runner;

import javax.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.jpa.experiments.entity.TaskEntity;
import com.jpa.experiments.repository.TaskRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Transactional
@Component
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Runner implements CommandLineRunner {


    TaskRepository taskRepo;


    @Override
    public void run(String... args) throws Exception {
        log.debug("*** START ***");

      for (TaskEntity task : taskRepo.findByTaskIdNotNull()) {
            log.debug(task.toString());
        }
 
      
        // for (TaskEntity task : taskRepo.findAllTasksInnerJoin()) {
        // log.debug("Join Fetch:: {}",task.toString());
        // }
        log.debug("*** END ***");

    }

}
