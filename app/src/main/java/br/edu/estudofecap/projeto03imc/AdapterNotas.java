package br.edu.estudofecap.projeto03imc;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;
import java.util.List;

public class AdapterNotas extends RecyclerView.Adapter<AdapterNotas.MyViewHolder> {

    private List<Materia> listaMaterias;
    @NonNull
    @Override
    public AdapterNotas.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View materia = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista_notas, parent, false);
        return new AdapterNotas.MyViewHolder(materia);
    }
    public AdapterNotas(List<Materia> listaMaterias){
        this.listaMaterias = listaMaterias;
    }
    @Override

    public void onBindViewHolder(@NonNull AdapterNotas.MyViewHolder holder, int position) {
        Materia materia = listaMaterias.get(position);

        holder.tituloMateria.setText(materia.getNomeMateria());

        double ni = materia.getNi();
        double pi = materia.getPi();
        double po = materia.getPo();

        double media = (ni*0.2) + (pi*0.3) + (po*0.5);

        holder.media.setText(arredondar(media));

        if(media >= 6.0){
            holder.status.setText("Aprovado");
        }else if(media < 6 && media > 5.0){
            holder.status.setText("Em exame");
        }else{
            holder.status.setText("Reprovado");
        }
    }

    private String arredondar(double salario){
        final DecimalFormat df = new DecimalFormat("0.00");
        return df.format(salario);
    }
    @Override
    public int getItemCount() {
        return listaMaterias.size();
    }
    public class MyViewHolder  extends RecyclerView.ViewHolder{
        TextView tituloMateria, media,status;
        public MyViewHolder (@NonNull View itemView) {
            super(itemView);

            tituloMateria = itemView.findViewById(R.id.txtNomeMateria);
            media = itemView.findViewById(R.id.txtMedia);
            status = itemView.findViewById(R.id.txtStatus);


        }

    }

}