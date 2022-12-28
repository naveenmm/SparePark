package com.example.sparepark.database

import androidx.room.*

@Entity
data class SpaceFinderRaw(
    @PrimaryKey(autoGenerate = true) val rowId: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "email") var email: String,
    @ColumnInfo(name = "password") var password: String,
    @ColumnInfo(name = "phone") var phone: String,
    @ColumnInfo(name = "street") var street: String,
    @ColumnInfo(name = "city") var city: String,
    @ColumnInfo(name = "state") var state: String,
    @ColumnInfo(name = "zip") var zip: String
)

@Dao
interface SpaceFinderDao {
    @Query("SELECT * FROM SpaceFinderRaw")
    fun getAll(): List<SpaceFinderRaw>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg spaceFinderRaw: SpaceFinderRaw)
}