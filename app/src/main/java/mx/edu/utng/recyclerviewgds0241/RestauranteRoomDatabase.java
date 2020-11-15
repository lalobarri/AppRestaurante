package mx.edu.utng.recyclerviewgds0241;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Anota la clase para que sea una base de datos de Room @Database
// y usa los parámetros de anotación para declarar las entidades que
// pertenecen a la base de datos y establecer el número de versión.

@Database(entities = {Restaurante.class}, version = 1, exportSchema = false)

//La clase de base de datos para Room debe ser abstracty extenderRoomDatabase
public abstract class RestauranteRoomDatabase extends RoomDatabase {
    //La base de datos expone DAO a través de un método "getter"
    // abstracto para cada @Dao.
    public abstract RestauranteDao restauranteDao();

    private static volatile RestauranteRoomDatabase INSTANCE;

    //De forma predeterminada, para evitar un rendimiento deficiente de la interfaz de usuario,
    // Room no le permite realizar consultas en el hilo principal. Cuando regresan las consultas de
    // Room LiveData, las consultas se ejecutan automáticamente de forma asincrónica en un hilo en
    // segundo plano.

    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    // Hemos definido un singleton , WordRoomDatabase,para evitar que se abran
    // varias instancias de la base de datos al mismo tiempo.
    static RestauranteRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RestauranteRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RestauranteRoomDatabase.class, "restaurante_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
