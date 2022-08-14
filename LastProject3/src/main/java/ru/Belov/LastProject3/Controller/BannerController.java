package ru.Belov.LastProject3.Controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.Belov.LastProject3.DTO.DTOBannerModel;
import ru.Belov.LastProject3.Models.BannerModel;
import ru.Belov.LastProject3.Services.BannerService;
import ru.Belov.LastProject3.Services.RequestsService;
import ru.Belov.LastProject3.until.BannerValidator;

import javax.servlet.http.HttpServletRequest;

@RestController
public class BannerController {
    private final
    BannerService bannerService;
    private final ModelMapper modelMapper;
    private final BannerValidator bannerValidator;
    private final RequestsService requestsService;

    @Autowired
    public BannerController(BannerService bannerService, ModelMapper modelMapper, BannerValidator bannerValidator, RequestsService requestsService) {
        this.bannerService = bannerService;
        this.modelMapper = modelMapper;
        this.bannerValidator = bannerValidator;
        this.requestsService = requestsService;
    }

    @PostMapping("/createBanner")
    public ResponseEntity<HttpStatus> createBanner(@RequestBody BannerModel bannerModel){
        bannerService.create(bannerModel);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/getBanner/{id}")
    @ResponseBody
    public DTOBannerModel getBanner(@PathVariable("id")int id, HttpServletRequest httpServletRequest){
       bannerService.getBannerId(id);
       DTOBannerModel dtoBannerModel=new DTOBannerModel();
       modelMapper.map(bannerService.getBannerId(id),dtoBannerModel);

        requestsService.create(httpServletRequest);

        return  dtoBannerModel;
    }
}
