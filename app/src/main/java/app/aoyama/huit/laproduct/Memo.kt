package app.aoyama.huit.laproduct

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "memo")
data class Memo(

    @PrimaryKey(autoGenerate = true)
    val mid: Int = 0,

    @ColumnInfo(name = "text")
    var text: String,
)