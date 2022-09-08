package app.aoyama.huit.laproduct

import androidx.room.*

@Dao
interface MemoDao {
    // データを追加
    @Insert
    fun insert(user: Memo)

    // データを更新
    @Update
    fun update(user: Memo)

    // データを削除
    @Delete
    fun delete(user: Memo)

    // 全てのデータを取得
    @Query("select * from memo")
    fun getAll(): List<Memo>

    // 全てのデータを削除
    @Query("delete from memo")
    fun deleteAll()

    // UserのuidがidのUserを取得
    @Query("select * from memo where mid = :id")
    fun getUser(id: Int): Memo

    @Query("select text from memo")
    fun getTextList():List<String>
}