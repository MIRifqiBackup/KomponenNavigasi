@file:Suppress("DEPRECATION")

package com.mobile.miftakhulilmanrifqi082.komponen_navigasi

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

import androidx.navigation.ui.NavigationUI
import com.mobile.miftakhulilmanrifqi082.komponen_navigasi.databinding.FragmentMainBinding

    class MainFragment : Fragment() {
        private var _fragmentMainBinding: FragmentMainBinding? = null
    private val fragmentMainBinding get() = _fragmentMainBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as AppCompatActivity).supportActionBar?.title = "Dompet DigitalKU"

        _fragmentMainBinding = FragmentMainBinding.inflate(inflater, container, false)
        val view = fragmentMainBinding.root

        fragmentMainBinding.btnLihatTransaksi.setOnClickListener{
            view.findNavController().navigate(R.id.action_mainFragment_to_viewBalanceFragment)
        }
        fragmentMainBinding.btnCekSaldo.setOnClickListener{
            view.findNavController().navigate(R.id.action_mainFragment_to_viewTransactionFragment2)
        }

        setHasOptionsMenu(true)
        return view
    }

    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, findNavController())
                || return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        _fragmentMainBinding = null
        super.onDestroyView()
    }
}
