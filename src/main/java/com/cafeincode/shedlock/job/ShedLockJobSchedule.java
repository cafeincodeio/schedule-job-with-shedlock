package com.cafeincode.shedlock.job;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.apache.commons.lang3.time.StopWatch;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@EnableAsync
@Component
@Slf4j
public class ShedLockJobSchedule {

    private static final String TASK_NAME = "JOB_SCHEDULE_AGGREGATE";

    @Scheduled(cron = "${shedlock.job.cron}")
    @SchedulerLock(name = TASK_NAME, lockAtLeastFor = "${shedlock.job.lockAtLeastFor}", lockAtMostFor = "${shedlock.job.lockAtMostFor}")
    @SneakyThrows
    public void run() {
        StopWatch watch = StopWatch.createStarted();
        writeLog();
        watch.stop();
        log.info("[Job] end schedule job total executed time :[{}] s", watch.getTime(TimeUnit.SECONDS));
    }

    private void writeLog() throws InterruptedException {
        log.info("[Job] started schedule job with shedlock by cafeincode");
        Thread.sleep(10000);
    }
}
