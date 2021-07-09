import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dorrrke.test_task.R
import com.dorrrke.test_task.jsonModel.TerminalDb

class TermViewHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(
    inflater.inflate(
        R.layout.recycler_items, parent, false
    )
) {

    private var terminalName: TextView? = null
    private var teminalAdres: TextView? = null
    private var worktable: TextView? = null
    private var map: ImageView? = null


    init {
        terminalName = itemView.findViewById(R.id.NameT)
        teminalAdres = itemView.findViewById(R.id.Adress)
        worktable = itemView.findViewById(R.id.workTable)
        map = itemView.findViewById(R.id.map)
    }

    fun bind(terminal: TerminalDb) {
        terminalName?.text = "Терминал: " + terminal.name
        teminalAdres?.text = "Адресс: " + terminal.address
        var table: String = "Расписание: "
        for (el in terminal.worktables) {
            var str = el.department + "\n"
            str += el.timetable + "\n" + "\n"

            table += str
        }
        worktable?.text = table



//        val inn =  java.net.URL(terminal.maps).openStream()
//        val img = BitmapFactory.decodeStream(inn)
//        map?.setImageBitmap(img)

    }
}