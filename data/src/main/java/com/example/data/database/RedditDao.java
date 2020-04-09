package com.example.data.database;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.domain.model.Children;

import java.util.List;

@Dao
public interface RedditDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertChildren(List<Children> children);

    @Query("select * from children")
    List<Children> getChildren();

    @Query("select * from children order by created_utc desc")
    DataSource.Factory<Integer, Children> getChildrenPaged();
}
