package com.mor.peppereview.framework.presentation

import androidx.lifecycle.*
import com.mor.peppereview.buisness.domain.models.Domain
import com.mor.peppereview.buisness.domain.state.DataState
import com.mor.peppereview.buisness.interactors.GetData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class MainViewModel
@Inject
constructor(
    private val getData: GetData,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _dataState: MutableLiveData<DataState<List<Domain>>> = MutableLiveData()

    val dataState: LiveData<DataState<List<Domain>>>
        get() = _dataState

    fun setStateEvent(mainStateEvent: MainStateEvent) {
        viewModelScope.launch {
            when (mainStateEvent) {
                is MainStateEvent.GetWeatherEvent -> {
                    getData.execute()
                        .onEach { dataState ->
                            _dataState.value = dataState
                        }
                        .launchIn(viewModelScope)
                }

                is MainStateEvent.GetCitiesEvent -> {
                    getData.execute()
                        .onEach { dataState ->
                            _dataState.value = dataState
                        }
                        .launchIn(viewModelScope)
                }
            }
        }
    }

}


sealed class MainStateEvent {

    class GetWeatherEvent(
        val lat: Double,
        val lon: Double,
        val citiesAmount: Int,
        val apiKey: String
    ) : MainStateEvent()

    class GetCitiesEvent : MainStateEvent()

    object None : MainStateEvent()
}










