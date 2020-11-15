package mx.edu.utng.recyclerviewgds0241;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Restaurante.class}, version = 1, exportSchema = false)
public abstract class RestauranteDatabase extends RoomDatabase {
    public abstract RestauranteDao getRestauranteDao();

}
