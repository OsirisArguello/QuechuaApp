package com.tdp2.quechuaapp.networking;

import com.tdp2.quechuaapp.model.Curso;
import com.tdp2.quechuaapp.model.Materia;
import com.tdp2.quechuaapp.model.Inscripcion;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface EstudianteApi {

    @GET("/public/cursos")
    Call<ArrayList<Curso>> getCursos();

    @GET("/public/materias")
    Call<ArrayList<Materia>> getMaterias();
//    Call<ArrayList<Materia>> getMateriasPorCarrera(@Path("carreraId")Integer carreraId);

    @GET("/public/materias/{materiaId}/cursos")
    Call<ArrayList<Curso>> getCursosPorMateria(@Path("materiaId")Integer materiaId);

    @POST("/public/inscripcion-cursos/{cursoId}/{alumnoId}")
    Call<Inscripcion> inscribirAlumno(@Path("alumnoId")Integer alumnoId, @Path("cursoId")Integer cursoId);
}
