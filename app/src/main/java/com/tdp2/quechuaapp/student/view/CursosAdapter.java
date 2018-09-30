package com.tdp2.quechuaapp.student.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.tdp2.quechuaapp.R;
import com.tdp2.quechuaapp.model.Alumno;
import com.tdp2.quechuaapp.model.Curso;
import com.tdp2.quechuaapp.model.Horario;
import com.tdp2.quechuaapp.model.Materia;

import java.util.ArrayList;

public class CursosAdapter extends ArrayAdapter<Curso> {

    private CursosAdapterCallback adapterCallback;
    Alumno alumno;

    public CursosAdapter(@NonNull Context context, @NonNull ArrayList<Curso> listaCursos, Alumno alumno) {
        super(context, 0,  listaCursos);
        this.alumno=alumno;
        try {
            this.adapterCallback = ((CursosAdapterCallback) context);
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement CursosAdapterCallback.");
        }
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Curso curso = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.curso_view, parent, false);
        }
        // Lookup view for data population

        if (position % 2 == 1) {
            convertView.setBackgroundColor(getContext().getResources().getColor(R.color.cursosBackground1));
        } else {
            convertView.setBackgroundColor(getContext().getResources().getColor(R.color.cursosBackground2));
        }

        TextView idCursoTextView = convertView.findViewById(R.id.idCurso);
        TextView docenteTextView = convertView.findViewById(R.id.nombreDocente);
        TextView diaTextView = convertView.findViewById(R.id.dia_horario);
        TextView horasTextView = convertView.findViewById(R.id.horas_horario);
        TextView aulaTextView = convertView.findViewById(R.id.aula_horario);


        final Button inscribirseButton = convertView.findViewById(R.id.inscribirseButton);

        inscribirseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapterCallback.inscribirAlumno(alumno.id,curso.id, inscribirseButton);
            }
        });


        if(curso.estaInscripto(alumno)) {
            inscribirseButton.setVisibility(View.INVISIBLE);
        }



        TextView vacantesTextView = convertView.findViewById(R.id.cantVacantes);

        idCursoTextView.setText("Curso: "+curso.id.toString());
        docenteTextView.setText("Docente: "+curso.profesor.apellido+", "+curso.profesor.nombre);

        StringBuilder diaString=new StringBuilder();
        StringBuilder horasString=new StringBuilder();
        StringBuilder aulaString=new StringBuilder();
        Integer cantHorarios=1;

        for (Horario horario : curso.horarios) {
            diaString.append(horario.dia);
            horasString.append(horario.horaInicio+"-"+horario.horaFin);
            aulaString.append(horario.aula);
            if(cantHorarios<curso.horarios.size()){
                diaString.append("\n");
                horasString.append("\n");
                aulaString.append("\n");
            }
            cantHorarios++;
        }

        diaTextView.setText(diaString.toString());
        horasTextView.setText(horasString.toString());
        aulaTextView.setText(aulaString.toString());

        vacantesTextView.setText("Vacantes: "+curso.getVacantes().toString());

        return convertView;
    }

}
