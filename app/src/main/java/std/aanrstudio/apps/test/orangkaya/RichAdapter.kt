package std.aanrstudio.apps.test.orangkaya

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class RichAdapter(private val listRich: ArrayList<Rich>) : RecyclerView.Adapter<RichAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_kaya, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listRich.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, desc, photo) = listRich[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.tvPhoto)

        holder.tvName.text = name
        holder.tvDesc.text = desc

        holder.cardView.setOnClickListener {
//            Toast.makeText(holder.itemView.context, "Kamu Memilih: ${listRich[position].name}", Toast.LENGTH_SHORT).show()
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("detail", position)
            it.context.startActivity(intent)
        }

    }

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDesc: TextView = itemView.findViewById(R.id.tv_item_from)
        var tvPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var cardView: CardView = itemView.findViewById(R.id.card_view)
    }

}