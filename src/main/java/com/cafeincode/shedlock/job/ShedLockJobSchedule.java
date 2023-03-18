package com.cafeincode.shedlock.job;

import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableAsync
@Component
@Slf4j
public class ShedLockJobSchedule {

    private static final String TASK_NAME = "JOB_SCHEDULE_AGGREGATE";
    private static final String LOCK_AT_LEAST_FOR = "30s";
    private static final String LOCK_AT_MOST_FOR = "10m";

    @Scheduled(cron = "0 0/2 * * * *")
    @SchedulerLock(name = TASK_NAME, lockAtLeastFor = LOCK_AT_LEAST_FOR, lockAtMostFor = LOCK_AT_MOST_FOR)
    public void run() {
        System.out.println("Start short running task");
    }
}
