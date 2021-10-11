package abc.com.roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val db by  lazy {
        Room.databaseBuilder(this,
            AppDatabase :: class.java,
            "User.db").allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            db.userDao().insert(User("Pankaj Kumar", "354334", "Fatehpur", 23,))
        }
        button2.setOnClickListener {
           val list= db.userDao().getAllUser()
            if (list.isNotEmpty()){
                with(list[0]){
                    textView.text= name
                    textView2.text=age.toString()
                    textView3.text=address
                    textView4.text=number
                }
            }
        }


    }
}