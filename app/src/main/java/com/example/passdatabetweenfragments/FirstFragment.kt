package com.example.passdatabetweenfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.findNavController
import com.example.passdatabetweenfragments.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var binding: FragmentFirstBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        val view = binding?.root;
        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.test?.text = "hi!"
//
//        val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(34)
//        findNavController().navigate(action)

        val receivedBundle = arguments
        binding?.test?.text = receivedBundle?.getInt("myValue").toString()


        val fragment2 = SecondFragment()
        val bundle2 = Bundle()
        bundle2.putInt("myValue2", 66)
        fragment2.arguments = bundle2
        val fragmentTransaction = activity?.supportFragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.nav_host_fragment, fragment2)
            ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            ?.commit()

    }

}