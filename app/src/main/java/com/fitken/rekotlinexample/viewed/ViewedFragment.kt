package com.fitken.rekotlinexample.viewed

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fitken.rekotlinexample.R

/**
 * Created by ken on 3/23/18.
 */
class ViewedFragment : Fragment() {

    companion object {
        fun newInstance(context: Context): ViewedFragment {
            return Fragment.instantiate(context, ViewedFragment::class.java.name, null) as ViewedFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return (DataBindingUtil.inflate(inflater, R.layout.fragment_viewed, container, false) as ViewDataBinding).root
    }
}