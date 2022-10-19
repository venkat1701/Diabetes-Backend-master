package io.github.venkat1701.diabetesbackend.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter @Setter
public class HeartResultEntity {

    @SerializedName("Age")
    private int age;

    @SerializedName("Sex")
    private int sex;

    @SerializedName("CP")
    private int CP;

    @SerializedName("RBP")
    private int RBP;

    @SerializedName("Cholestrol")
    private int chol;

    @SerializedName("FBS")
    private int FBS;

    @SerializedName("RestECG")
    private int restECG;

    @SerializedName("Thalach")
    private int thalach;

    @SerializedName("Exang")
    private int exang;

    @SerializedName("OldPeak")
    private int oldpeak;

    @SerializedName("Slope")
    private int slope;

    @SerializedName("CA")
    private int CA;

    @SerializedName("Thal")
    private int thal;

    @SerializedName("Test_Accuracy")
    private double testAccuracy;

    @SerializedName("Result")
    private String result;


    public List<String> getHeartParametersList() {
        return List.of(
                "Result",
                "Test_Accuracy",
                "Age",
                "Sex",
                "CP",
                "RBP",
                "Cholestrol",
                "FBS",
                "RestECG",
                "Thalach",
                "Exang",
                "OldPeak",
                "Slope",
                "CA",
                "Thal"
                );
    }

    public List<String> getHeartValuesList() {
        return List.of(this.getResult(),
                this.getTestAccuracy()+"",
                this.getAge()+"",
                this.getSex()+"",
                this.getCP()+"",
                this.getRBP()+"",
                this.getChol()+"",
                this.getFBS()+"",
                this.getRestECG()+"",
                this.getThalach()+"",
                this.getExang()+"",
                this.getOldpeak()+"",
                this.getSlope()+"",
                this.getCA()+"",
                this.getThal()+""
        );
    }
}
