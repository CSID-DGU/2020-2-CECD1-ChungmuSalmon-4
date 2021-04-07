package com.chungmusalmon.hangangreporter.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chungmusalmon.hangangreporter.domain.usecase.LoadSectionUseCase
import com.chungmusalmon.hangangreporter.viewmodel.model.Section
import kotlinx.coroutines.launch

class MainViewModel(
    private val loadSectionUseCase: LoadSectionUseCase
) : ViewModel() {
    private val state = State()

    fun state() : State = state
    fun loadLocate(){
        viewModelScope.launch {
            state.locate.value = loadSectionUseCase.build()
            Log.e("test", state.locate.value!!.size.toString())
        }
    }


    data class State(
        val locate: MutableLiveData<ArrayList<Section>> = MutableLiveData()
    )

}