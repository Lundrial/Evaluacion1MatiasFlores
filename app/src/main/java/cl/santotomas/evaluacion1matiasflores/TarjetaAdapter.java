package cl.santotomas.evaluacion1matiasflores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TarjetaAdapter extends ArrayAdapter<ModeloTarjeta> {
    private Context mContext;
    private List<ModeloTarjeta> listaTarjetas = new ArrayList<>();

    public TarjetaAdapter(@NonNull Context context, List<ModeloTarjeta> list) {
        super(context, 0, list);
        mContext = context;
        listaTarjetas = list;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.single_item,parent,false);

        ModeloTarjeta modeloTarjeta = listaTarjetas.get(position);

        TextView tv_nombre = (TextView) listItem.findViewById(R.id.tv_nombre);
        tv_nombre.setText(modeloTarjeta.getNombre());

        TextView tv_numero = (TextView) listItem.findViewById(R.id.tv_numtarjeta);
        tv_numero.setText(modeloTarjeta.getNum_tarjeta());

        TextView tv_fecha = (TextView) listItem.findViewById(R.id.tv_fecha);
        tv_fecha.setText(modeloTarjeta.getFecha());

        return listItem;
    }
}
