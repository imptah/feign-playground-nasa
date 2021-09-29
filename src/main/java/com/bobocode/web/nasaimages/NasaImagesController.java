package com.bobocode.web.nasaimages;

import com.bobocode.web.nasaimages.model.NasaResponse;
import com.bobocode.web.nasaimages.model.PhotoInfo;
import com.bobocode.web.nasaimages.service.ImageDownloadService;
import com.bobocode.web.nasaimages.service.NasaImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
public class NasaImagesController {

    @Autowired
    NasaImageService nasaimageService;

    @Autowired
    ImageDownloadService nasaDownload;

    private List<PhotoInfo> photoSrcCache = new ArrayList<>();

    @RequestMapping("/images")
    public ResponseEntity<?> getImagesSrc() {
        NasaResponse curiosityPhotos = nasaimageService.getCuriosityPhotos();
        List<String> imageSrc = curiosityPhotos.getPhotos().stream().map(PhotoInfo::getUri).collect(Collectors.toList());
        return new ResponseEntity<>(imageSrc, HttpStatus.OK);
    }

    @RequestMapping(value = "/random", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<?> downloadImage() {

        if (photoSrcCache == null || photoSrcCache.isEmpty()) {
            photoSrcCache = nasaimageService.getCuriosityPhotos().getPhotos();
        }

        Random random = new Random();
        PhotoInfo photoInfo = photoSrcCache.get(random.nextInt(photoSrcCache.size()));
        String imageName = photoInfo.getUri().substring(photoInfo.getUri().lastIndexOf("/") + 1);
        byte[] image = nasaDownload.downloadPhoto(imageName);
        return new ResponseEntity<>(image, HttpStatus.OK);
    }

}
