package br.edu.estudofecap.projeto03imc;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class AdapterMaterias extends RecyclerView.Adapter<AdapterMaterias.MyViewHolder> {

    private List<Materia> listaMaterias;
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View materia = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.input_notas, parent, false);
        return new MyViewHolder(materia);
    }
    public AdapterMaterias(List<Materia> listaMaterias){
        this.listaMaterias = listaMaterias;
    }
    @Override

    public void onBindViewHolder(@NonNull MyViewHolder  holder, int position) {
        Materia materia = listaMaterias.get(position);
        holder.tituloMateria.setText(materia.getNomeMateria());
        if(materia.getNi() == 0.0  ||   materia.getNi() == null){
            holder.inputNI.setText("");
        }else{
            holder.inputNI.setText(materia.getNi()+"");
        }

        if(materia.getPi() == 0.0  ||   materia.getNi() == null){
            holder.inputPI.setText("");
        }else{
            holder.inputPI.setText(materia.getPi()+"");
        }

        if(materia.getPo() == 0.0  ||   materia.getNi() == null){
            holder.inputPO.setText("");
        }else{
            holder.inputPO.setText(materia.getPo()+"");
        }
    }

    public void limparDados(){
        for(Materia materia: listaMaterias){
            materia.setNi(0.0);
            materia.setPi(0.0);
            materia.setPo(0.0);
        }
    }

    @Override
    public int getItemCount() {
        return listaMaterias.size();
    }
    public class MyViewHolder  extends RecyclerView.ViewHolder{
        TextView tituloMateria;
        TextInputEditText inputNI, inputPI, inputPO;


        public MyViewHolder (@NonNull View itemView) {
            super(itemView);

            tituloMateria = itemView.findViewById(R.id.txtMateria);
            inputNI = itemView.findViewById(R.id.inputMateriaNI);
            inputPI = itemView.findViewById(R.id.inputMateriaPI);
            inputPO = itemView.findViewById(R.id.inputMateriaPO);

        }

    }

}
