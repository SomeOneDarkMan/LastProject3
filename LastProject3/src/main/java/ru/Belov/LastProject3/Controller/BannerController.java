package ru.Belov.LastProject3.Controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.Belov.LastProject3.DTO.DTOBannerModel;
import ru.Belov.LastProject3.Models.BannerModel;
import ru.Belov.LastProject3.Services.BannerService;
import ru.Belov.LastProject3.Services.RequestsService;
import ru.Belov.LastProject3.until.BannerValidator;
import ru.Belov.LastProject3.until.Exceptions.BannerNotCreatException;
import ru.Belov.LastProject3.until.ReqExceptoins.BannerExceptionResponse;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Banner")
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


    @GetMapping("/get/{id}")
    @ResponseBody
    public DTOBannerModel getBanner(@PathVariable("id")int id, HttpServletRequest httpServletRequest){
       bannerService.getBannerId(id);
       DTOBannerModel dtoBannerModel=new DTOBannerModel();
       modelMapper.map(bannerService.getBannerId(id),dtoBannerModel);

     //   requestsService.create(httpServletRequest); для проверки было

        return  dtoBannerModel;
    }
    @PostMapping("/delete/{id}")
    public HttpStatus deleteBanner(@PathVariable("id")int id){
        bannerService.madeDelete(id);

        return HttpStatus.OK;

    }
    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createBanner(@RequestBody @Valid DTOBannerModel dtoBannerModel ,BindingResult bindingResult){
        BannerModel bannerModel=new BannerModel();
        modelMapper.map(dtoBannerModel,bannerModel);
        bannerValidator.validate(bannerModel,bindingResult);

        if(bindingResult.hasErrors()){
            List<FieldError> errorsList=bindingResult.getFieldErrors();

            StringBuilder stringBuilder=new StringBuilder();

            for(FieldError fieldError:errorsList){

                stringBuilder.append(fieldError.getField()+": "+fieldError.getDefaultMessage()+"|");

            }

            throw new BannerNotCreatException( stringBuilder.toString());

        }

        bannerService.create(bannerModel);
        return new ResponseEntity<>(HttpStatus.IM_USED);
    }
    @ExceptionHandler
    private BannerExceptionResponse notCreate(BannerNotCreatException bannerEX){
        return new BannerExceptionResponse(bannerEX.getMessage());
    }

}
