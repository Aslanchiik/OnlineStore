package com.example.onlinestore.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.core.Resource
import com.example.onlinestore.presentation.state.UIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected fun <T> MutableUIStateFlow() = MutableStateFlow<UIState<T>>(UIState.Idle())

    protected open fun <TDomain, T> MutableStateFlow<UIState<T>>.subscribeTo(
        request: suspend () -> Flow<Resource<TDomain>>, mappedData: (TDomain) -> T
    ): Job {
        return viewModelScope.launch(Dispatchers.IO) {
            request().collect {
                when (it) {
                    is Resource.Loading -> {
                        this@subscribeTo.value = UIState.Loading()
                    }

                    is Resource.Error -> {
                        if (it.message != null) {
                            this@subscribeTo.value = UIState.Error(it.message ?: "Error")
                        } else {
                            it.errorBody?.let { error ->
                                this@subscribeTo.value = UIState.Error(error)
                            }
                        }
                    }

                    is Resource.Success -> it.data?.let { data ->
                        this@subscribeTo.value = UIState.Success(mappedData(data))
                    }
                }
            }
        }
    }

    protected fun <T, S> Flow<Resource<T>>.collectUI(
        state: MutableStateFlow<UIState<S>>,
        successful: (T?) -> S?
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            state.value = UIState.Loading()
            this@collectUI.collect {
                when (it) {
                    is Resource.Error -> {
                        state.value = UIState.Error(it.message.toString())
                    }

                    is Resource.Loading -> {
                    }

                    is Resource.Success -> {
                        successful(it.data)?.let {
                            state.value = UIState.Success(it)
                        }
                    }
                }
            }
        }
    }
}