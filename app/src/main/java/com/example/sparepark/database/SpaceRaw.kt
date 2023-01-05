package com.example.sparepark.database

import androidx.room.*

@Entity
data class SpaceRaw(
    @PrimaryKey(autoGenerate = true) val rowId: Int,
//    @ColumnInfo(typeAffinity = ColumnInfo.BLOB) val image: ByteArray? = null,
    @ColumnInfo(name = "space_name") var spaceName: String,
    @ColumnInfo(name = "per_hour") var perHour: String,
    @ColumnInfo(name = "street") var street: String,
    @ColumnInfo(name = "city") var city: String,
    @ColumnInfo(name = "state") var state: String,
    @ColumnInfo(name = "zip") var zip: String,
    @ColumnInfo(name = "map_link") var mapLink: String,
    @ColumnInfo(name = "authorized") var authorized: Int
)

@Dao
interface SpaceDao {
    @Query("SELECT * FROM SpaceRaw")
    fun getAll(): List<SpaceRaw>

    @Query("SELECT * FROM SpaceRaw WHERE authorized=1")
    fun getAuthorized(): List<SpaceRaw>

    @Query("SELECT * FROM SpaceRaw WHERE authorized=0")
    fun getUnauthorized(): List<SpaceRaw>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg spaceRaw: SpaceRaw)

    @Query("UPDATE SpaceRaw SET authorized=:authorized WHERE rowId=:rowId")
    fun updateAuthorized(authorized: Boolean, rowId: Int)
}