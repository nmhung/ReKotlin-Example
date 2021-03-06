package com.fitken.rekotlinexample.ui.shopitemdetails

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.SystemClock
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import com.fitken.rekotlinexample.R
import com.fitken.rekotlinexample.actions.ActionComment
import com.fitken.rekotlinexample.actions.ActionLike
import com.fitken.rekotlinexample.actions.ActionView
import com.fitken.rekotlinexample.databinding.ActivityShopItemDetailsBinding
import com.fitken.rekotlinexample.ui.explore.Comment
import com.fitken.rekotlinexample.ui.explore.ShopItem
import com.fitken.rekotlinexample.store


class ShopItemDetailsActivity : AppCompatActivity(), ShopItemDetailsView {

    private lateinit var mBinding: ActivityShopItemDetailsBinding
    private lateinit var mShopItem: ShopItem
    private lateinit var mAdapter: CommentsAdapter

    companion object {
        private const val KEY_SHOP_ITEM = "shopItem"

        fun start(context: Context, shopItem: ShopItem) {
            val intent = Intent(context, ShopItemDetailsActivity::class.java)
            intent.putExtra(KEY_SHOP_ITEM, shopItem)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_shop_item_details)
        mBinding.view = this

        mShopItem = intent.getSerializableExtra(KEY_SHOP_ITEM) as ShopItem
        mBinding.shopItem = mShopItem
        mAdapter = CommentsAdapter()
        mBinding.rvComments.adapter = mAdapter
        mAdapter.update(mShopItem.comments)

        store.dispatch(ActionView(mShopItem))
    }

    override fun onLikeClicked() {
        var count: Int = mShopItem.likeCount.toInt()
        count++
        mShopItem.likeCount = count.toString()
        mBinding.tvLike.text = mShopItem.likeCount
        store.dispatch(ActionLike(mShopItem))
    }

    override fun onCommentSent(message: String) {
        mBinding.etMessage.setText("")
        mBinding.etMessage.clearFocus()
        mShopItem.comments.add(Comment("Anonymous ${SystemClock.uptimeMillis()}", message))
        mAdapter.update(mShopItem.comments)

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(mBinding.etMessage.windowToken, 0)

        mBinding.tvComment.text = "${mShopItem.comments.size} comment(s)"

        store.dispatch(ActionComment(mShopItem))
//        ShopItemManager.instance.updateItem(mShopItem)
    }
}
