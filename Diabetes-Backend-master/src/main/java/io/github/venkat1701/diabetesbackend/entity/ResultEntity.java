package io.github.venkat1701.diabetesbackend.entity;


import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter @Setter
public class ResultEntity {

    @SerializedName("Pregnancies")
    private int pregnancies;

    @SerializedName("Glucose")
    private int glucose;

    @SerializedName("Blood_Pressure")
    private int bloodPressure;

    @SerializedName("Skin_Thickness")
    private int skinThickness;

    @SerializedName("Insulin")
    private int insulin;

    @SerializedName("BMI")
    private int BMI;

    @SerializedName("Pedigree")
    private double diabetesPedigree;

    @SerializedName("Age")
    private int age;

    @SerializedName("Result")
    private String result;

    @SerializedName("AccuracyScore")
    private double accuracyScore;


    private Map<String, String> resultsMap;


    public List<String> getResultValuesList() {
        return List.of(this.getResult(),
                this.getPregnancies()+"",
                this.getGlucose()+"",
                this.getBloodPressure()+"",
                this.getSkinThickness()+"",
                this.getInsulin()+"",
                this.getBMI()+"",
                this.getDiabetesPedigree()+"",
                this.getAge()+"",
                this.getAccuracyScore()+"%");

    }

    public List<String> getResultParametersList() {
        return List.of("Result",
                "Pregnancies",
                "Glucose",
                "Blood Pressure",
                "Skin Thickness",
                "Insulin",
                "BMI",
                "Diabetes Pedigree",
                "Age",
                "Accuracy Score");
    }
}
