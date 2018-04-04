import android.content.Context

/**
 * Created by HunJin on 2018-04-04.
 */

abstract class BaseAdapter<ITEM>(context: Context) : AbstractRecyclerViewAdapter<ITEM, BaseViewHolder<ITEM>>(context) {

    override fun onBindViewHolder(holder: BaseViewHolder<ITEM>, position: Int) {
        holder.onBindViewHolder(getItem(position), position)
    }
}