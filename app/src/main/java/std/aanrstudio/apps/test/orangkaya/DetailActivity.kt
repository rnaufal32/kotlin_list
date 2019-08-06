package std.aanrstudio.apps.test.orangkaya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val nama_lengkap: TextView = findViewById(R.id.nama_lengkap)
        val foto: ImageView = findViewById(R.id.imageView)
        val alias: TextView = findViewById(R.id.alias)
        val profesi: TextView = findViewById(R.id.profesi)
        val biografi: TextView = findViewById(R.id.biografi)

        val listRich: ArrayList<Rich> = arrayListOf()
        listRich.addAll(RichData.listData)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val id = intent.getIntExtra("detail", 0)
        nama_lengkap.text = listRich[id].namalengkap
        alias.text = listRich[id].name
        profesi.text = listRich[id].profesi
        biografi.text = listRich[id].biografi

        Glide.with(this)
            .load(listRich[id].photo)
            .apply(RequestOptions().override(55, 55))
            .into(foto)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
