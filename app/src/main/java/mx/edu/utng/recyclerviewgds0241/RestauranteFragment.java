package mx.edu.utng.recyclerviewgds0241;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static mx.edu.utng.recyclerviewgds0241.RestauranteRoomDatabase.databaseWriteExecutor;


//import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class RestauranteFragment extends Fragment {

    //Declaraciones:
    RecyclerView recyclerView;
    public List<Restaurante> restauranteList;
    private MyRestauranteRecyclerViewAdapter adapterRestaurantes;
    //Objeto de la calse
    private RestauranteLab mRestaurante;

    public MyRestauranteRecyclerViewAdapter getAdapterRestaurantes() {
        return adapterRestaurantes;
    }

    public void setAdapterRestaurantes(MyRestauranteRecyclerViewAdapter adapterRestaurantes) {
        this.adapterRestaurantes = adapterRestaurantes;
    }

    public RestauranteLab getmRestaurante() {
        return mRestaurante;
    }

    public void setmRestaurante(RestauranteLab mRestaurante) {
        this.mRestaurante = mRestaurante;
    }

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RestauranteFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static RestauranteFragment newInstance(int columnCount) {
        RestauranteFragment fragment = new RestauranteFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurante_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            //recyclerView.setAdapter(new MyRestauranteRecyclerViewAdapter(DummyContent.ITEMS));
            //Agragar elementos a la lista:

            //Obtiene la conexión
            mRestaurante = RestauranteLab.get(getContext());

            try {
                Restaurante r = new Restaurante();
                r.setNombre("Pizza Plaza");
                r.setUrlPhoto("https://cdn.kiwilimon.com/recetaimagen/13003/0.jpg");
                r.setValoracion(3.5f);
                r.setDireccion("Plaza principal #10");


                mRestaurante.addRestaurante(r);

            }catch (Exception e){
                Toast.makeText(getContext(), "Hay un error con los datos por favor intenta nuevamente, Error"+e.getMessage(),Toast.LENGTH_LONG).show();
            }

                List<Restaurante> restaurantes = mRestaurante.getRestaurantes();





                adapterRestaurantes = new MyRestauranteRecyclerViewAdapter(getActivity(), restaurantes);
                recyclerView.setAdapter(adapterRestaurantes);

        }
        return view;
    }




}