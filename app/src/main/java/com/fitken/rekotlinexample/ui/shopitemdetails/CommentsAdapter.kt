package com.fitken.rekotlinexample.ui.shopitemdetails

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.fitken.rekotlinexample.databinding.ItemCommentBinding
import com.fitken.rekotlinexample.ui.explore.Comment

/**
 * Created by ken on 3/23/18.
 */
class CommentsAdapter : RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder>() {

    private var mComments = ArrayList<Comment>()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CommentsViewHolder {
        return CommentsViewHolder(ItemCommentBinding.inflate(LayoutInflater.from(parent?.context), parent, false))
    }

    override fun getItemCount(): Int {
        return mComments.size
    }

    override fun onBindViewHolder(holder: CommentsViewHolder?, position: Int) {
        holder?.bindData(mComments[position])
    }

    fun update(comments: ArrayList<Comment>) {
        mComments.clear()
        mComments.addAll(comments)
    }

    class CommentsViewHolder(private val itemCommentBinding: ItemCommentBinding) : RecyclerView.ViewHolder(itemCommentBinding.root) {

        fun bindData(comment: Comment) {
            itemCommentBinding.comment = comment
        }
    }
}