package com.tdp2.quechuaapp.networking;


import com.tdp2.quechuaapp.model.Curso;

import retrofit2.Call;

import retrofit2.mock.BehaviorDelegate;

public class MockDocenteService implements DocenteApi {

    private final BehaviorDelegate<DocenteApi> delegate;

    public MockDocenteService(BehaviorDelegate<DocenteApi> delegate) {
        this.delegate = delegate;
    }

    @Override
    public Call<Curso> getCurso(Integer cursoId) {
        Curso curso = new Curso();
        curso.id=cursoId;

        return delegate.returningResponse(curso).getCurso(cursoId);
    }


}