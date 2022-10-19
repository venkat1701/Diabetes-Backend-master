package io.github.venkat1701.diabetesbackend.controller;

import com.google.gson.Gson;
import io.github.venkat1701.diabetesbackend.entity.HeartResultEntity;
import io.github.venkat1701.diabetesbackend.entity.ResultEntity;
import org.python.icu.text.Normalizer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeartController {

    @RequestMapping("/heart")
    public ModelAndView getHeart() {
        var mv = new ModelAndView();
        mv.setViewName("heart.html");

        return mv;
    }

    @RequestMapping(value="/heartData")
    public ModelAndView predictData(@RequestParam("Age")float age,
                                    @RequestParam("Sex")float sex,
                                    @RequestParam("CP")float cp,
                                    @RequestParam("Rest_Blood_Pressure")float restbp,
                                    @RequestParam("Cholestrol")float chol,
                                    @RequestParam("Fasting_Blood_Sugar")float fbp,
                                    @RequestParam("Rest_ECG")double recg,
                                    @RequestParam("Thalach")float thalach,
                                    @RequestParam("Exang")float exang,
                                    @RequestParam("OldPeak")float oldpeak,
                                    @RequestParam("Slope")float slope,
                                    @RequestParam("CA")float ca,
                                    @RequestParam("Thal")float thal){
        String URI = String.format("http://127.0.0.1:8585/predict/heart?Age=%f&Sex=%f&CP=%f&Rest_Blood_Pressure=%f&Cholestrol=%f&Fasting_Blood_Sugar=%f&Rest_ECG=%f&Thalach=%f&Exang=%f&OldPeak=%f&Slope=%f&CA=%f&Thal=%f",
                age, sex, cp, restbp, chol, fbp, recg, thalach, exang, oldpeak, slope, ca, thal);
        RestTemplate template = new RestTemplate();
        String result = template.getForObject(URI, String.class);
        var gson = new Gson();
        var entity = gson.fromJson(result, HeartResultEntity.class);
        System.out.println(result);

        var mv = new ModelAndView();
        mv.setViewName("heart.html");
        mv.addObject("parameters", entity.getHeartParametersList());
        mv.addObject("values", entity.getHeartValuesList());
        return mv;
    }
}
