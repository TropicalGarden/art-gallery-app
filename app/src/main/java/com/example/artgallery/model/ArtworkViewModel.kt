package com.example.artgallery.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.artgallery.network.model.TokenRequest
import com.example.artgallery.network.service.DeviantApi
import kotlinx.coroutines.launch

class ArtworkViewModel : ViewModel() {

    enum class DeviantApiStatus { LOADING, ERROR, DONE }

    private val _status = MutableLiveData<DeviantApiStatus>()
    val status: LiveData<DeviantApiStatus> = _status

    private val _art = MutableLiveData<Art>()
    val art: LiveData<Art> = _art

    init {
        getArtworks()
    }

    private fun getArtworks() {
        viewModelScope.launch {
            _status.value = DeviantApiStatus.LOADING
            try {
                val token = DeviantApi.retrofitService.getToken(
                    TokenRequest.grantType,
                    TokenRequest.clientId,
                    TokenRequest.clientSecret
                )

                _art.value = DeviantApi.retrofitService.getArt(
                    "${token.tokenType} ${token.accessToken}"
                )

                _status.value = DeviantApiStatus.DONE

            } catch (e: Exception) {
                _status.value = DeviantApiStatus.ERROR
                _art.value?.artworks = listOf()
            }
        }
    }

}