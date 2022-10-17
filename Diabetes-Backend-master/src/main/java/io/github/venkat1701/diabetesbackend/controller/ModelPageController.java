package io.github.venkat1701.diabetesbackend.controller;


import lombok.SneakyThrows;
import org.graalvm.polyglot.Context;
import org.python.core.Py;
import org.python.core.PyFunction;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.file.Paths;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

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
        this.executePythonFile();

        var mv = new ModelAndView();
        mv.setViewName("model.html");
        return mv;
    }

    @SneakyThrows
    public void executePythonFile() {
        PythonInterpreter pythonInterpreter = new PythonInterpreter();
        FileInputStream fis = new FileInputStream("C:\\Users\\krish\\OneDrive\\Desktop\\Diabetes-Backend-master\\Diabetes-Backend-master\\src\\main\\python\\diabetes_prediction.py");
        pythonInterpreter.execfile(fi);
        PyFunction pyFunction = (PyFunction) pythonInterpreter.get("get_pred", PyFunction.class);
        pyFunction.__call__();
    }



}
