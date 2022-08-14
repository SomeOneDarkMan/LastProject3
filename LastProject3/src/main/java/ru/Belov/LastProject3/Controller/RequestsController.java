package ru.Belov.LastProject3.Controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.Belov.LastProject3.DTO.DTORequestsModel;
import ru.Belov.LastProject3.DTO.SecondDTORequestsModel;
import ru.Belov.LastProject3.Models.RequestsModel;
import ru.Belov.LastProject3.Services.RequestsService;
import ru.Belov.LastProject3.until.RequestsValidator;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/Requests")
public class RequestsController {
    private final ModelMapper modelMapper;
    private final RequestsService requestsService;
    private final RequestsValidator requestsValidator;
    @Autowired
    public RequestsController(ModelMapper modelMapper, RequestsService requestsService, RequestsValidator requestsValidator) {
        this.modelMapper = modelMapper;
        this.requestsService = requestsService;
        this.requestsValidator = requestsValidator;
    }
@GetMapping("/get")
    public SecondDTORequestsModel createRequests(HttpServletRequest httpServletRequest){

    RequestsModel requestsModel=requestsService.getRequests(httpServletRequest);
    SecondDTORequestsModel seconddtoRequestsModel=new SecondDTORequestsModel();
    modelMapper.map(requestsModel,seconddtoRequestsModel);

           return seconddtoRequestsModel ;
    }
}
