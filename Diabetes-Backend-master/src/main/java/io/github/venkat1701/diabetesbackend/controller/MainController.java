package io.github.venkat1701.diabetesbackend.controller;

import io.github.venkat1701.diabetesbackend.model.ChooseBoxModel;
import io.github.venkat1701.diabetesbackend.model.PortfolioImageModel;
import io.github.venkat1701.diabetesbackend.model.ServiceBoxModel;
import org.python.icu.text.Normalizer;
import org.python.modules._systemrestart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {




    @RequestMapping("/")
    @ResponseBody
    public ModelAndView index(Model model){
        var mv = new ModelAndView();
        mv.setViewName("index.html");

        Map<String, List> map = new HashMap<>();
        map.put("services", this.getServiceBoxModel());
        map.put("boxes", this.getChooseBoxModel());
        map.put("portfolioimages", this.getPortfolioImageModel());
        model.addAllAttributes(map);
        return mv;
    }



    public List<ChooseBoxModel> getChooseBoxModel() {
        List<ChooseBoxModel> chooseBoxModels = new ArrayList<>();
        chooseBoxModels.add(new ChooseBoxModel("images/icons/worker.png", "PROFESSIONAL HELP", "We provide 24x7 medical support."));
        chooseBoxModels.add(new ChooseBoxModel("images/icons/gear.png", "USER-FRIENDLY", "Our website have simple UI that enables the patient to interact in a friendly way."));
        chooseBoxModels.add(new ChooseBoxModel("images/icons/headset.png", "AFFORDABLE PRICES", "Our prediction models are free of cost."));
        chooseBoxModels.add(new ChooseBoxModel("images/icons/heart-attack.png", "CONSULT OUR DOCTORS", "Our doctors are available on the call with minimal waiting time."));
        chooseBoxModels.add(new ChooseBoxModel("images/icons/stethoscope-medical-tool.png", "CARDIOLOGIST", "We predict about the heart diseases and illnesses."));
        chooseBoxModels.add(new ChooseBoxModel("images/icons/cardio.png", "ACCURATE", "Our models are accurate and precise in predicting diseases."));

        return chooseBoxModels;
    }

    public List<ServiceBoxModel> getServiceBoxModel() {
        List<ServiceBoxModel> serviceBoxes = new ArrayList<>();
        serviceBoxes.add(new ServiceBoxModel("/images/diabetes.png", "DIABETES PREDICTION", "Medicare's finest models, based on input parameters of client, predicts if a person is Diabetic or not."));
        serviceBoxes.add(new ServiceBoxModel("/images/corona.png", "HEART DISEASE PREDICTION", "Medicare, on the basis of some parameters, predicts whether the client has a healthy heart or not."));
        serviceBoxes.add(new ServiceBoxModel("/images/corona.png", "MORE UPCOMING..", "Developers and Doctors in Medicare are working on more prediction models currently..."));

        return serviceBoxes;
    }

    public List<PortfolioImageModel> getPortfolioImageModel(){
        List<PortfolioImageModel> portfolioImg = new ArrayList<>();
        portfolioImg.add(new PortfolioImageModel("images/case%20study/01.jpg"));
        portfolioImg.add(new PortfolioImageModel("images/case%20study/02.jpg"));
        portfolioImg.add(new PortfolioImageModel("images/case%20study/03.jpg"));
        portfolioImg.add(new PortfolioImageModel("images/case%20study/04.jpg"));
        portfolioImg.add(new PortfolioImageModel("images/case%20study/05.jpg"));

        return portfolioImg;
    }
}
