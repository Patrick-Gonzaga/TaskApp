package com.example.taskapp.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskapp.R
import com.example.taskapp.UI.adapter.TaskAdapter
import com.example.taskapp.data.model.Task
import com.example.taskapp.databinding.FragmentTodoBinding

class TodoFragment : Fragment() {
    private var _binding: FragmentTodoBinding? = null

    private val binding get() = _binding!!

    private lateinit var taskAdapter: TaskAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        initRecyclerView(getTasks())
    }

    private fun initListeners() {
        binding.FAB.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_formTaskFragment)
        }
    }

    private fun initRecyclerView(taskList: List<Task>){
        taskAdapter = TaskAdapter(taskList)

        val rvTasks = binding.rvTasks
        rvTasks.layoutManager = LinearLayoutManager(requireContext())
        rvTasks. setHasFixedSize(true)
        rvTasks.adapter = taskAdapter
    }

    private fun getTasks() = listOf(
        Task("0", "Ajudar idosa a atravessar a rua"),
        Task("2", "Rebolar lentin pros crias"),
        Task("3", "Alimentar mendigos aleatórios")
    )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}