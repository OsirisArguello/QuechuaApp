
package com.tdp2.quechuaapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Alumno implements Serializable {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("nombre")
    @Expose
    public String nombre;
    @SerializedName("apellido")
    @Expose
    public String apellido;
    @SerializedName("padron")
    @Expose
    public String padron;
    @SerializedName("prioridad")
    @Expose
    public Integer prioridad;
    @SerializedName("userId")
    @Expose
    public Integer userId;
    @SerializedName("firebaseToken")
    @Expose
    public String firebaseToken;

}
