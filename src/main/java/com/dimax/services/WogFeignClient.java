package com.dimax.services;

import com.dimax.models.api.WogResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "wogFeignClient", url = "https://api.wog.ua/fuel_stations")
public interface WogFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/809", produces = "application/json")
    WogResponse getStationById();

}
