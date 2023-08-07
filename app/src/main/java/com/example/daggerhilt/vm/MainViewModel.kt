package com.example.daggerhilt.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggerhilt.model.MainUsers
import com.example.daggerhilt.model.UserData
import com.example.daggerhilt.repository.GithubRepository
import com.example.daggerhilt.repository.JsonPlasholderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val jsonPlasholderRepository: JsonPlasholderRepository,
    private val githubRepository: GithubRepository
) : ViewModel() {
    private val _flow = MutableStateFlow<Resource<MainUsers>>(Resource.Loading())
    val flow get() = _flow

    init {
        getJsonPlaseHolderUsers()
    }

    private fun getJsonPlaseHolderUsers() {
        viewModelScope.launch {

            // paralele holatda zapros
            combine(
                jsonPlasholderRepository.getJsonPlaceHolderUsers(),
                githubRepository.getGithubUsers()
            ) { it1, it2 ->
                _flow.emit(Resource.Success(MainUsers(it1,it2)))
            }.catch {
                _flow.emit(Resource.Failure(it))
            }

            // yakka holatda zapros
//            jsonPlasholderRepository.getJsonPlaceHolderUsers()
//                .catch {
//                    _flow.emit(Resource.Failure(it))
//                }
//                .collect {
//                    _flow.emit(Resource.Success(it))
//                }
        }

    }
}