package abc.com.roomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao{
    @Insert
    fun insert(user: User)

    @Insert
    fun  insertAll(list: List<User>)
    @Delete
    fun delete(user: User)

    @Query("Select + From User")
    fun getAllUser() : List<User>

    @Query("Select + From User WHERE age > :age")
    fun getUserWithAge(age:Int) : List<User>

}