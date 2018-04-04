
import android.support.v7.widget.RecyclerView

/**
 * Created by HunJin on 2018-04-04.
 */
interface BaseRecyclerView {

    var onItemClickListener: OnItemClickListener?

    fun setOnItemClickListener(listener: (RecyclerView.Adapter<*>, Int)->Unit)

    fun notifyDataSetChanged()

}