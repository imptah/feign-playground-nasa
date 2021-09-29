package com.bobocode.web.nasaimages.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "nasa-download", url = "https://mars.nasa.gov/msl-raw-images/msss/01000/mcam/")
public interface ImageDownloadService {
    @RequestMapping(method = RequestMethod.GET, value = "/{imageName}")
    byte[] downloadPhoto(@PathVariable String imageName);
}