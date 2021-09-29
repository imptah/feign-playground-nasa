package com.bobocode.web.nasaimages.service;

import com.bobocode.web.nasaimages.model.NasaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "nasa", url = "https://api.nasa.gov/mars-photos/api/v1/rovers")
public interface NasaImageService {
    @RequestMapping(method = RequestMethod.GET, value = "/curiosity/photos?sol=1000&api_key=DEMO_KEY")
    NasaResponse getCuriosityPhotos();
}