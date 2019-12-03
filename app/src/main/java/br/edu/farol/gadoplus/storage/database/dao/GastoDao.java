package br.edu.farol.gadoplus.storage.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.edu.farol.gadoplus.model.Gasto;

@Dao
public interface GastoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Gasto gasto);

    @Delete
    void delete(Gasto gasto);

    @Query("DELETE FROM gasto")
    void deleteAll();

    @Update
    void update(Gasto gasto);

    @Query("SELECT * FROM gasto WHERE id = :Id")
    Gasto getById(int Id);

    @Query("SELECT * from gasto")
    LiveData<List<Gasto>> getAll();

}
