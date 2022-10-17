package io.github.venkat1701.diabetesbackend.model.abst;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class BoxModel {
    protected String title;
    protected String data;
}
