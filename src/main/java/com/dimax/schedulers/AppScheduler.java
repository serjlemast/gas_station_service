package com.dimax.schedulers;

import com.dimax.services.WogFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppScheduler {

    private final WogFeignClient wogFeignClient;

    @Scheduled(cron = "0 0/1 * * * *")
    public void scheduleFixedDelayTask() {
        System.out.println(" >>>>>>>   Fixed delay task - " + wogFeignClient.getStationById());
    }

}
