package io.github.venkat1701.diabetesbackend.controller;


import com.google.gson.Gson;
import io.github.venkat1701.diabetesbackend.entity.ResultEntity;
import lombok.SneakyThrows;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Controller
public class ModelPageController {


    @RequestMapping("/model")
    public ModelAndView getModel() {
        var mv = new ModelAndView();
        mv.setViewName("model.html");

        return mv;
    }

    @RequestMapping(value = "/modelData")
    public ModelAndView predictData(@RequestParam("Pregnancies")int pregnancies,
                            @RequestParam("Glucose")int glucose,
                            @RequestParam("Blood_Pressure")int bp,
                            @RequestParam("Skin_Thickness")int thickness,
                            @RequestParam("Insulin")int insulin,
                            @RequestParam("BMI")int bmi,
                            @RequestParam("Pedigree")double pedigree,
                            @RequestParam("Age")int age){

        System.out.println(pregnancies+", "+glucose+", "+bp+", "+thickness+", "+insulin+", "+bmi+", "+pedigree+", "+age);


        String URI = String.format("http://127.0.0.1:8585/predict/result?Pregnancies=%d&Glucose=%d&Blood_Pressure=%d&Skin_Thickness=%d&Insulin=%d&BMI=%d&Pedigree=%f&Age=%d",
                    pregnancies, glucose, bp, thickness, insulin, bmi, pedigree/1000, age);
        RestTemplate template = new RestTemplate();
        String result = template.getForObject(URI, String.class);
        var gson = new Gson();
        var entity = gson.fromJson(result, ResultEntity.class);
        System.out.println(result);



        var mv = new ModelAndView();
        mv.setViewName("model.html");
        mv.addObject("parameters", entity.getResultParametersList());
        mv.addObject("values", entity.getResultValuesList());
        return mv;
    }


}
