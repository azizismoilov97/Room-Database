package admiral.group.myapplication.fragments.list

import admiral.group.myapplication.R
import admiral.group.myapplication.viewmodel.UserViewModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list.view.*


class ListFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_list, container, false)

        //RecyclerView
        val adapter=ListAdapter()
        val recyclerView=view.recyclerView
        recyclerView.adapter=adapter
        recyclerView.layoutManager=LinearLayoutManager(requireContext())


        //UserViewModel
        mUserViewModel=ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer { user->
            adapter.saveData(user)
        })

        view.floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_addFragment2)
        }

        return view
    }

}